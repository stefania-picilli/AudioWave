package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.OrdineDAO;
import model.dao.ProdottoAcquistatoDAO;
import model.dao.ProdottoDAO;
import model.dto.CarrelloBean;
import model.dto.OrdineBean;
import model.dto.ProdottoAcquistatoBean;
import model.dto.ProdottoBean;
import model.dto.ProdottoNelCarrelloBean;
import model.dto.UtenteBean;

/**
 * Servlet implementation class Ordine
 */
@WebServlet("/Ordine")
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Ordine.class.getName());
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordine() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
		
		//se carrello vuoto, pagina ordine non disponibile
		if(carrello == null || carrello.isEmpty()) {
			response.sendError(404);
			return;
		}
		
		request.setAttribute("parziale", carrello.getTotale());
		request.setAttribute("costoSpedizione", CarrelloBean.COSTO_SPEDIZIONE);
		request.setAttribute("totale", carrello.getTotaleConSpedizione());
		
		
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/user/ordine.jsp");
		dis.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
		
			String indirizzo = request.getParameter("indirizzo");
			String numeroCarta = request.getParameter("numero");
			String intestatario = request.getParameter("intestatario");
			String scadenza = request.getParameter("scadenza");
			String cvv = request.getParameter("cvv");
			
			
			HttpSession session = request.getSession();
			UtenteBean account = (UtenteBean) session.getAttribute("account");
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			
			
			if(carrello == null || carrello.isEmpty()) {
				inviaEsito(false, "Ops, non è stato possibile portare a termine l'ordine: non sono presenti prodotti nel carrello", request, response);
				return;
			}
			
			List<ProdottoNelCarrelloBean> listProdotti = carrello.getProdotti();
			
			if(!datiValidi(indirizzo, numeroCarta, intestatario, scadenza, cvv)) {
				inviaEsito(false, "Ops, non è stato possibile portare a termine l'ordine: dati inviati non validi", request, response);
				return;
			}
			
			ProdottoDAO daoProd = new ProdottoDAO();
			
			//aggiornamento dati e controllo disponibilit� dei bean presenti nel carrello
			for(ProdottoNelCarrelloBean prodCarr : listProdotti) {
					
				ProdottoBean prodottoDB = daoProd.doRetrieveByKey(prodCarr.getProdotto().getCodiceProdotto() + "");
				
				//se dati diversi, aggiorna bean nel carrello
				if(!prodottoDB.equals(prodCarr.getProdotto()))
					prodCarr.setProdotto(prodottoDB);
				
				//controllo disponibilit�
				if(prodCarr.getQuantita() > prodottoDB.getDisponibilita()) {
					
					inviaEsito(false, "Ops, non è stato possibile portare a termine l'ordine: la disponibilit� dei prodotti � cambiata", request, response);
					return;
					
				}
				
				
			}
				
				
			//decremento disp prodotti nel DB
				
			for(ProdottoNelCarrelloBean prodCarr : listProdotti) {
				
				daoProd.decrementaDisp(prodCarr.getProdotto().getCodiceProdotto(), prodCarr.getQuantita());
				
			}
			
			
			//creazione ordine
			OrdineBean ordine = new OrdineBean();
			
			ordine.setData(LocalDate.now().toString());
			ordine.setIndirizzo(indirizzo);
			ordine.setStatoOrdine("Pagato");
			ordine.setCostoTotale(carrello.getTotaleConSpedizione());
			ordine.setMetodoPagamento(numeroCarta.substring(numeroCarta.length() - 5, numeroCarta.length() - 1));
			ordine.setEmail(account.getEmail());
			
			OrdineDAO daoOrdine = new OrdineDAO();
			int numeroOrdine = daoOrdine.doSave(ordine);
			
			
			//creazione prodotti acquistati
			ProdottoAcquistatoBean prodA = new ProdottoAcquistatoBean();
			ProdottoAcquistatoDAO daoProdA = new ProdottoAcquistatoDAO();
			
			for(ProdottoNelCarrelloBean prodCarr : listProdotti) {
			
				ProdottoBean prodotto = prodCarr.getProdotto();
				
				prodA.setNumeroOrdine(numeroOrdine);
				prodA.setNome(prodotto.getNome());
				prodA.setMarca(prodotto.getMarca());
				prodA.setImmagine(prodotto.getImmagine());
				prodA.setPrezzo(prodotto.getPrezzo());
				prodA.setIva(prodotto.getIva());
				prodA.setQuantita(prodCarr.getQuantita());
				prodA.setCodiceProdotto(prodotto.getCodiceProdotto());
				
				daoProdA.doSave(prodA);
			
			}	
				
			//svuota carrello	
			carrello.svuota();
			
			
			inviaEsito(true, "Il tuo ordine verrà presto preso in carico", request, response);
		
		
		}catch(SQLException e) {
			
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}
	
	
	private void inviaEsito(boolean esitoPositivo, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		if(esitoPositivo)
			request.setAttribute("esito", "positivo");
		else
			request.setAttribute("esito", "negativo");
			
	
		request.setAttribute("message", message);
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/user/esitoOrdine.jsp");
		dis.forward(request, response);
		
	}
	
	private boolean datiValidi(String indirizzo, String numero, String intestatario, String scadenza, String cvv) {
		
		if(indirizzo == null || indirizzo.equals(""))
			return false;
		
		if(numero.length() > 16 || numero.length() < 13)
			return false;
		
		if(intestatario == null || intestatario.equals(""))
			return false;
		
		if(cvv == null || cvv.length() != 3)
			return false;
		
		if(scadenza == null || scadenza.equals("")) 
			return false;
		else {
			
			//se scaduta ritorna false
			System.out.println("Scadenza=" + scadenza);
			
			//String[] scad = scadenza.split("/|-");
			String[] scad = scadenza.split("[/-]");
			
			int meseScad = Integer.parseInt(scad[0]);
			System.out.println("mese=" + meseScad);
			int annoScad = Integer.parseInt(scad[1]);
			System.out.println("anno=" + annoScad);
			
			LocalDateTime localDate = LocalDateTime.now();
			int annoAttuale = localDate.getYear() - 2000;
			System.out.println("annoAttuale=" + annoAttuale);
			int meseAttuale = localDate.getMonthValue();
			System.out.println("meseAttuale=" + meseAttuale);
			
			
			if((annoAttuale >= annoScad) && (annoAttuale != annoScad || meseAttuale > meseScad))
				return false;
			
		}
		
		
		
		return true;
		
	}
	

}

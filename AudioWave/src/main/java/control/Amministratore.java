package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoriaDAO;
import model.dao.OrdineDAO;
import model.dao.ProdottoAcquistatoDAO;
import model.dao.ProdottoDAO;
import model.dao.SpedizioneDAO;
import model.dao.UtenteDAO;
import model.dto.CategoriaBean;
import model.dto.OrdineBean;
import model.dto.ProdottoAcquistatoBean;
import model.dto.ProdottoBean;
import model.dto.SpedizioneBean;
import model.dto.UtenteBean;

/**
 * Servlet implementation class Amministratore
 */
@WebServlet("/Amministratore")
public class Amministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Amministratore.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Amministratore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
		
			String action = request.getParameter("action");
			
			if(action.equals("c-prodotto")) {
				
				CategoriaDAO dao = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) dao.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/creaProdotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("v-prodotti")) {
				
				ProdottoDAO dao = new ProdottoDAO();
				List<ProdottoBean> prodotti = (List<ProdottoBean>) dao.doRetrieveAll();
				request.setAttribute("prodotti", prodotti);
				
				CategoriaDAO daoC = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) daoC.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveMaxPrezzo();
				request.setAttribute("maxPrezzo", prodotto.getPrezzoConIva());
				/*request.setAttribute("rimuovicat", 0);*/
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/prodotti.jsp");
				dis.forward(request, response);
				
			}else if(action.equals("v-prodotto")){
				
				String codiceProdotto = request.getParameter("codice");
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveByKey(codiceProdotto);
				request.setAttribute("prodotto", prodotto);
				
				
				int disp = prodotto.getDisponibilita();
				String disponibilita = "";
				String colore = "";
				
				if(disp >= 5) { 
					
					disponibilita = "Disponibile";
					colore = "green-text";
					
				}else if(disp > 1) {
					
					disponibilita = "Solo " + disp +  " disponibili";
					colore = "yellow-text";
					
				}else if(disp == 1) {
					
					disponibilita = "Solo " + disp +  " disponibile";
					colore = "yellow-text";
				
				}else {
					
					disponibilita = "Non disponibile";
					colore = "red-text";
					
				}
				
				request.setAttribute("disponibilita", disponibilita);
				request.setAttribute("colore", colore);
				
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/prodotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("m-prodotto")){
				
				String codiceProdotto = request.getParameter("codice");
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveByKey(codiceProdotto);
				request.setAttribute("prodotto", prodotto);
				
				CategoriaDAO daoC = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) daoC.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/modificaProdotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("v-ordini")) {
				
				//String utente = request.getParameter("utente");
				String dataIniziale = request.getParameter("da");
				String dataFinale = request.getParameter("a");
				
				/*String utenteQuery = "";
				
				if(utente != null && utente != "" && !utente.equals("Tutti"))
					utenteQuery = utente;*/
				
				OrdineDAO daoO = new OrdineDAO();
				String primaData = daoO.doRetrievePrimaData();
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dataOggi = simpleDateFormat.format(new Date());
				
			
				if(dataIniziale == "" || dataIniziale == null || dataFinale == null || dataFinale == "") {
					
					dataIniziale = primaData;
					dataFinale = dataOggi;
					
				}
			
				List<OrdineBean> ordini = (List<OrdineBean>) daoO.doRetrieveAll();
				//List<OrdineBean> ordini = (List<OrdineBean>) dao.doRetrieveByParameters(utenteQuery, dataIniziale, dataFinale, "data DESC");
				
				
				UtenteDAO daoAcc = new UtenteDAO();
				List<UtenteBean> utenti = (List<UtenteBean>) daoAcc.doRetrieveAll(); //mettere ordinamento per email
				
				request.setAttribute("ordini", ordini);
				request.setAttribute("utenti", utenti);
				request.setAttribute("da", dataIniziale);
				request.setAttribute("a", dataFinale);
				
				
				/*if(utenteQuery == null || utenteQuery == "")
					utenteQuery = "Tutti";
				request.setAttribute("utenteScelto", utenteQuery);*/
				
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ordini.jsp");
				dis.forward(request, response);
				
			}else if(action.equals("v-ordine")) {
				
				String num = request.getParameter("num");
				
				OrdineDAO ordDAO = new OrdineDAO();
				OrdineBean ordine = ordDAO.doRetrieveByKey(num);
				
				if(ordine == null) {
					
					response.sendError(404);
					return;
					
				}
				
				
				ProdottoAcquistatoDAO prodDAO = new ProdottoAcquistatoDAO();
				List<ProdottoAcquistatoBean> prodotti = (List<ProdottoAcquistatoBean>) prodDAO.doRetrieveByOrdine(num);
				
				SpedizioneDAO spedDAO = new SpedizioneDAO();
				SpedizioneBean spedizione = spedDAO.doRetrieveByOrdine(num);
				
				request.setAttribute("prodotti", prodotti);
				request.setAttribute("ordine", ordine);
				request.setAttribute("spedizione", spedizione);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ordine.jsp");
				dis.forward(request, response);
				
				
			}
			
		
		}catch(SQLException e) {
			
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		
		
			String action = request.getParameter("action");
			
			
			if(action.equals("c-prodotto")) {
				
				String nome = request.getParameter("nome");
				String immagine = request.getParameter("immagine");
				String marca = request.getParameter("marca");
				String descrizione = request.getParameter("descrizione");
				double prezzo = Double.parseDouble(request.getParameter("prezzo"));
				int disponibilita = Integer.parseInt(request.getParameter("disponibilita"));
				double iva = Double.parseDouble(request.getParameter("iva"));
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				String tag = request.getParameter("tag");
				
				
				ProdottoBean prodotto = new ProdottoBean();
				prodotto.setNome(nome);
				prodotto.setImmagine(immagine);
				prodotto.setMarca(marca);
				prodotto.setTag(tag);
				prodotto.setDescrizione(descrizione);
				prodotto.setPrezzo(prezzo);
				prodotto.setDisponibilita(disponibilita);
				prodotto.setIva(iva);
				prodotto.setCategoriaID(categoria);
				
				
				ProdottoDAO dao = new ProdottoDAO();
				dao.doSave(prodotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}else if(action.equals("m-prodotto")) {
				
				String codice = request.getParameter("id");		
				String nome = request.getParameter("nome");
				String immagine = request.getParameter("immagine");
				String marca = request.getParameter("marca");
				String descrizione = request.getParameter("descrizione");
				String prezzo = request.getParameter("prezzo");
				String disponibilita = request.getParameter("disponibilita");
				String iva = request.getParameter("iva");
				String categoria = request.getParameter("categoria");
				String tag = request.getParameter("tag");
				
				ProdottoDAO dao = new ProdottoDAO();
				ProdottoBean prodotto = new ProdottoBean();
				
				prodotto.setCodiceProdotto(Integer.parseInt(codice));
				prodotto.setNome(nome);
				prodotto.setImmagine(immagine);
				prodotto.setMarca(marca);
				prodotto.setTag(tag);
				prodotto.setDescrizione(descrizione);
				prodotto.setPrezzo(Double.parseDouble(prezzo));
				prodotto.setDisponibilita(Integer.parseInt(disponibilita));
				prodotto.setIva(Double.parseDouble(iva));
				prodotto.setCategoriaID(Integer.parseInt(categoria));
			
				dao.updateProdotto(prodotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
				
			}else if(action.equals("m-spedizione")) {
				
				String corriere = request.getParameter("corriere");
				String dataPartenza = request.getParameter("data-partenza");
				String dataArrivo = request.getParameter("data-arrivo");
				int numeroOrdine = Integer.parseInt(request.getParameter("numeroOrdine"));
				
				
				SpedizioneBean spedizione = new SpedizioneBean();
				
				spedizione.setCorriere(corriere);
				spedizione.setDataPartenza(dataPartenza);
				spedizione.setDataArrivo(dataArrivo);
				spedizione.setNumeroOrdine(numeroOrdine);
				
				SpedizioneDAO dao = new SpedizioneDAO();
				dao.doSave(spedizione);
				
				OrdineDAO ordDAO = new OrdineDAO();
				ordDAO.doUpdateStato(numeroOrdine, "Spedito");
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}else if(action.equals("r-prodotto")) {
				
				String codiceProdotto = request.getParameter("codice");
				
				ProdottoDAO dao = new ProdottoDAO();
				dao.doDelete(codiceProdotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}/*else if(action.equals("v-ordini")) {
				
				
				String dataIniziale = request.getParameter("da");
				String dataFinale = request.getParameter("a");
				
				
				OrdineDAO daoO = new OrdineDAO();
				String primaData = daoO.doRetrievePrimaData();
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dataOggi = simpleDateFormat.format(new Date());
				
			
				if(dataIniziale == "" || dataIniziale == null || dataFinale == null || dataFinale == "") {
					
					dataIniziale = primaData;
					dataFinale = dataOggi;
					
				}
			
				List<OrdineBean> ordini = (List<OrdineBean>) daoO.doRetrieveAll();
				//List<OrdineBean> ordini = (List<OrdineBean>) dao.doRetrieveByParameters(utenteQuery, dataIniziale, dataFinale, "data DESC");
				
				
				UtenteDAO daoAcc = new UtenteDAO();
				List<UtenteBean> utenti = (List<UtenteBean>) daoAcc.doRetrieveAll(); //mettere ordinamento per email
				
				request.setAttribute("ordini", ordini);
				request.setAttribute("utenti", utenti);
				request.setAttribute("da", dataIniziale);
				request.setAttribute("a", dataFinale);
				
				
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ordini.jsp");
				dis.forward(request, response);
				
			}*/else
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
		
		}catch(SQLException e) {
			
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}

}

package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import model.dao.ProdottoDAO;
import model.dto.CarrelloBean;
import model.dto.ProdottoBean;
import model.dto.ProdottoNelCarrelloBean;

/**
 * Servlet implementation class Carrello
 */
@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Carrello.class.getName());
	private static final String CARRELLO_NAME = "carrello";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrello() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			
			
			HttpSession session = request.getSession();
			CarrelloBean carrello = (CarrelloBean) session.getAttribute(CARRELLO_NAME);
			
			
			//se carrello non esiste nella sessione, ne crea uno
			if(carrello == null) {
						
				carrello = new CarrelloBean();
				session.setAttribute(CARRELLO_NAME, carrello);
						
			}
				
			List<String> messaggi = controlloProdotti(carrello.getProdotti());
			
			session.setAttribute(CARRELLO_NAME, carrello);	
			request.setAttribute("totale", carrello.getTotale());
			
			request.setAttribute("costoSpedizione", CarrelloBean.COSTO_SPEDIZIONE);
			
			if(!messaggi.isEmpty())
				request.setAttribute("messaggi", messaggi);
				
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/carrello.jsp");
			dis.forward(request, response);
			
		}catch(SQLException e) {
		
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		
		}
			
	}
		
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			
			String add = request.getParameter("add");
			String remove = request.getParameter("remove");
			String removeAll = request.getParameter("removeAll");
			
			
			HttpSession session = request.getSession();
			CarrelloBean carrello = (CarrelloBean) session.getAttribute(CARRELLO_NAME);
			
			//se carrello non esiste nella sessione, ne crea uno
			if(carrello == null) {
						
				carrello = new CarrelloBean();
				session.setAttribute(CARRELLO_NAME, carrello);
						
			}
			
			List<String> messaggi = controlloProdotti(carrello.getProdotti());
			carrello.calcolaTotale();
			
			int quantita = 0;
			
			if(add != null && !add.equals("")) {
				
				quantita = aggiungiProdotto(add, carrello, messaggi, session);
					
				
			}else if(remove != null && !remove.equals("")){
				
				quantita = rimuoviProdotto(remove, carrello, messaggi, session);
				
			}else if(removeAll != null && !removeAll.equals("")) {
				
				quantita = rimuoviProdotti(removeAll, carrello, messaggi, session);
				
			}
			
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			
			json.put("subTotale", carrello.getTotale());
			json.put("totale", carrello.getTotaleConSpedizione());
			json.put("quantita", quantita);
			json.put("messaggi", messaggi);
			
			out.print(json.toString());
			
		
		}catch(SQLException e) {
		
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
	
		}
		
	}
	
	
	
	private ProdottoBean search(String codiceProdotto) throws SQLException{
		
		ProdottoDAO dao = new ProdottoDAO();
		ProdottoBean prodotto = null;
			
		prodotto = dao.doRetrieveByKey(codiceProdotto);
			
		if(prodotto == null)
			return null;
			
		return prodotto;
		
		
	}
	
	
	private List<String> controlloProdotti(List<ProdottoNelCarrelloBean> listProdotti) throws SQLException{
		
		List<String> messaggi = new LinkedList<>();
		
		StringBuilder messaggioElim = new StringBuilder();
		StringBuilder messaggioDisp = new StringBuilder();
		
		ProdottoDAO daoProd = new ProdottoDAO();
		
		for(int i = 0; i < listProdotti.size(); i++) {
			
			ProdottoNelCarrelloBean prodCarr = listProdotti.get(i);
			
			ProdottoBean prodottoDB = daoProd.doRetrieveByKey(prodCarr.getProdotto().getCodiceProdotto() + "");
			
			if(prodottoDB == null) {
				
				//prodotto non trovato nel database
				messaggioElim.append("Uno o pi&ugrave; prodotti potrebbero non essere pi&ugrave; presenti sulla piattaforma");
				listProdotti.remove(i);
				continue;
				
			}
			
			//se dati diversi, aggiorna bean nel carrello
			if(!prodottoDB.equals(prodCarr.getProdotto()))
				prodCarr.setProdotto(prodottoDB);
			
			//controllo disponibilit�
			if(prodCarr.getQuantita() > prodottoDB.getDisponibilita()) {
				
				if(prodottoDB.getDisponibilita() <= 0)
					listProdotti.remove(i);
				else 
					prodCarr.setQuantita(prodottoDB.getDisponibilita());
				
				
				messaggioDisp.append("\n" + prodottoDB.getNome());
				
			}
			
			
		}
		
		if(messaggioDisp.length() > 0)
			messaggi.add("La disponibilita dei seguenti prodotti &egrave; diminuita (potrebbero non essere pi&ugrave; presenti nel carrello):" +  messaggioDisp);
			
		if(messaggioElim.length() > 0)
			messaggi.add(messaggioElim + "");
		
		return messaggi;
		
	}
	
	
	private int aggiungiProdotto(String add, CarrelloBean carrello, List<String> messaggi, HttpSession session) throws SQLException{
		
		ProdottoBean prod;
		int quantita = 0;
		
		if((prod = search(add)) != null) {
			
			
			if(!carrello.add(prod)) {
				
				messaggi.add("Impossibile aggiungere il prodotto, disponibilità non sufficiente");
				quantita = 0;
				
			}else 
				quantita = 1;
			
			
			
			session.setAttribute(CARRELLO_NAME, carrello);
		
		}else {
			
			messaggi.add("Impossibile aggiungere il prodotto al carrello: il prodotto non esiste");
			quantita = 0;
			
		}
		
		return quantita;
		
	}
	
	private int rimuoviProdotto(String remove, CarrelloBean carrello, List<String> messaggi, HttpSession session) throws SQLException{
		
		int quantita = 0;
		int codice = Integer.parseInt(remove);
		
		if(carrello.remove(codice)) {
			
			session.setAttribute(CARRELLO_NAME, carrello);
			quantita = -1;
		
		}else {
			
			messaggi.add("Impossibile rimuovere il prodotto");
			quantita = 0;
			
		}
		
		return quantita;
		
	}
	
	private int rimuoviProdotti(String removeAll, CarrelloBean carrello, List<String> messaggi, HttpSession session) throws SQLException{
		
		int quantita = 0;
		
		int codice = Integer.parseInt(removeAll);
		
		if(carrello.removeAll(codice)) {
		
			session.setAttribute(CARRELLO_NAME, carrello);
			
		}else {
			
			messaggi.add("Impossibile rimuovere il prodotto");
			
		}
		
		
		return quantita;
		
	}
	

}

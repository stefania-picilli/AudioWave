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
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			
			String carrelloAttr = "carrello";
			
			//se carrello non esiste nella sessione, ne crea uno
			if(carrello == null) {
						
				carrello = new CarrelloBean();
				session.setAttribute(carrelloAttr, carrello);
						
			}
				
			List<String> messaggi = controlloProdotti(carrello.getProdotti());
			
			session.setAttribute(carrelloAttr, carrello);	
			request.setAttribute("totale", carrello.getTotale());
			
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
		
			System.out.println("Richesta ricevuta");
			
			String add = request.getParameter("add");
			System.out.println("add=" + add);
			String remove = request.getParameter("remove");
			String removeAll = request.getParameter("removeAll");
			
			String carrelloAttr = "carrello";
			
			HttpSession session = request.getSession();
			System.out.println("Sessione ottenuta");
			CarrelloBean carrello = (CarrelloBean) session.getAttribute(carrelloAttr);
			
			//se carrello non esiste nella sessione, ne crea uno
			if(carrello == null) {
						
				carrello = new CarrelloBean();
				session.setAttribute(carrelloAttr, carrello);
						
			}
			
			
			System.out.println("Carrello ottenuto");
			
			
			List<String> messaggi = controlloProdotti(carrello.getProdotti());
			carrello.calcolaTotale();
			
			int quantita = 0;
			
			if(add != null && !add.equals("")) {
					
				ProdottoBean prod;
				
				if((prod = search(add)) != null) {
					
					System.out.println("search diverso da null");
					
					if(!carrello.add(prod)) {
						
						messaggi.add("Impossibile aggiungere prodotto, disponibilità non sufficiente");
						quantita = 0;
						
					}else 
						quantita = 1;
					
					
					System.out.println("Aggiunto a carrello");
					
					session.setAttribute(carrelloAttr, carrello);
				
				}else {
					
					messaggi.add("Impossibile aggiungere il prodotto al carrello: il prodotto non esiste");
					quantita = 0;
					
				}
					
				
			}else if(remove != null && !remove.equals("")){
				
				int codice = Integer.parseInt(remove);
				
				if(carrello.remove(codice)) {
					
					session.setAttribute(carrelloAttr, carrello);
					quantita = -1;
				
				}else {
					
					messaggi.add("Impossibile rimuovere il prodotto");
					quantita = 0;
					
				}
				
			}else if(removeAll != null && !removeAll.equals("")) {
				
				int codice = Integer.parseInt(removeAll);
				
				if(carrello.removeAll(codice)) {
				
					session.setAttribute(carrelloAttr, carrello);
					
				}else {
					
					messaggi.add("Impossibile rimuovere il prodotto");
					
				}
				
			}
			
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			
			json.put("subTotale", carrello.getTotale());
			json.put("totale", carrello.getTotaleConSpedizione());
			json.put("quantita", quantita);
			json.put("messaggi", messaggi);
			
			System.out.println("JSON da servlet:" + json);
			
			out.print(json.toString());
			
		
		}catch(SQLException e) {
		
			//response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
	
		}
		
	}
	
	
	
	private ProdottoBean search(String codiceProdotto){
		
		ProdottoDAO dao = new ProdottoDAO();
		ProdottoBean prodotto = null;
		
		
		System.out.println("codiceProdotto=" + codiceProdotto + ".");
		
		try {
			
			prodotto = dao.doRetrieveByKey(codiceProdotto);
			
			System.out.println("Prodotto=" + prodotto);
			
			if(prodotto == null)
				return null;
			
			return prodotto;
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
			return null;
		}
		
		
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
				messaggioElim.append("Uno o più prodotti potrebbero non essere più presenti sulla piattaforma");
				listProdotti.remove(i);
				continue;
				
			}
			
			//se dati diversi, aggiorna bean nel carrello
			if(!prodottoDB.equals(prodCarr.getProdotto()))
				prodCarr.setProdotto(prodottoDB);
			
			//controllo disponibilità
			if(prodCarr.getQuantita() > prodottoDB.getDisponibilita()) {
				
				if(prodottoDB.getDisponibilita() <= 0)
					listProdotti.remove(i);
				else 
					prodCarr.setQuantita(prodottoDB.getDisponibilita());
				
				
				messaggioDisp.append("\n" + prodottoDB.getNome());
				
			}
			
			
		}
		
		if(messaggioDisp.length() > 0)
			messaggi.add("La disponibilita dei seguenti prodotti è diminuita (potrebbero non essere più presenti nel carrello):" +  messaggioDisp);
			
		if(messaggioElim.length() > 0)
			messaggi.add(messaggioElim + "");
		
		return messaggi;
		
	}
	

}

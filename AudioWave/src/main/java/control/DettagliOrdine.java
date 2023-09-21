package control;

import java.io.IOException;
import java.sql.SQLException;
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
import model.dao.SpedizioneDAO;
import model.dto.CarrelloBean;
import model.dto.OrdineBean;
import model.dto.ProdottoAcquistatoBean;
import model.dto.SpedizioneBean;
import model.dto.UtenteBean;

/**
 * Servlet implementation class DettagliOrdine
 */
@WebServlet("/DettagliOrdine")
public class DettagliOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DettagliOrdine.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliOrdine() {
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
			String numeroOrdine = request.getParameter("num");
			
			
			HttpSession session = request.getSession();
			UtenteBean account = (UtenteBean) session.getAttribute("account");
			
			OrdineDAO ordDAO = new OrdineDAO();
			OrdineBean ordine = ordDAO.doRetrieveByKey(numeroOrdine);
			
			//se l'ordine non esiste o non è dell'utente, invia errore 404
			if(ordine == null || !account.getEmail().equals(ordine.getEmail())) {
				
				response.sendError(404);
				return;
				
			}
			
			
			ProdottoAcquistatoDAO prodDAO = new ProdottoAcquistatoDAO();
			List<ProdottoAcquistatoBean> prodotti = (List<ProdottoAcquistatoBean>) prodDAO.doRetrieveByOrdine(numeroOrdine);
			
			
			request.setAttribute("prodotti", prodotti);
			request.setAttribute("ordine", ordine);
			
			
			if(action.equals("visualizza")) {
				
				SpedizioneDAO spedDAO = new SpedizioneDAO();
				SpedizioneBean spedizione = spedDAO.doRetrieveByOrdine(numeroOrdine);
				
				request.setAttribute("spedizione", spedizione);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/user/dettagliOrdine.jsp");
				dis.forward(request, response);
				
			}else if(action.equals("fattura")) {
				
				double imponibile = 0;
				
				for(ProdottoAcquistatoBean prod : prodotti)	
					imponibile += prod.getPrezzo() * prod.getQuantita();
					
				double impostaIVA = ordine.getCostoTotale() - imponibile;
				
				request.setAttribute("impostaIVA", (double) Math.round((impostaIVA - 5) * 100) / 100);
				request.setAttribute("imponibile", (double) Math.round(imponibile * 100) / 100);
				request.setAttribute("account", account);
				request.setAttribute("totaleParziale", ordine.getCostoTotale() - 5);
				request.setAttribute("costoSpedizione", CarrelloBean.COSTO_SPEDIZIONE);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/user/fattura.jsp");
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
		doGet(request, response);
	}

}

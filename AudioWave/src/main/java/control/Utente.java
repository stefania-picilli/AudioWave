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
import model.dto.OrdineBean;
import model.dto.UtenteBean;

/**
 * Servlet implementation class Utente
 */
@WebServlet("/Utente")
public class Utente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Utente.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Utente() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			HttpSession session = request.getSession();
			UtenteBean account = (UtenteBean) session.getAttribute("account");
			
			//estrai tutti gli ordini dell'utente
			OrdineDAO ordDAO = new OrdineDAO();
			List<OrdineBean> ordini = (List<OrdineBean>) ordDAO.doRetrieveByAccount(account.getEmail());
			
			//invia lista di ordini
			if(ordini != null && !ordini.isEmpty()) {
				
				request.setAttribute("ordini", ordini);
		
			}
				
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/user/utente.jsp");
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
		
		doGet(request, response);
	}

}

package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UtenteDAO;
import model.dto.UtenteBean;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Registrazione.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/registrazione.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nascita = request.getParameter("nascita");
		String cellulare = request.getParameter("cellulare");
		
		HttpSession session = request.getSession(true);
		String path = (String) session.getAttribute("path");
		
		try {
		
			//controllare se email gi� presente in DB
			
			if(exists(email)) {
				
				request.setAttribute("messaggio", "Impossibile effettuare la registrazione, email gi&agrave; esistente.");
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/registrazione.jsp");
				dis.forward(request, response);
				return;
				
			}
			
			UtenteBean account = new UtenteBean();
			account.setEmail(email);
			account.setPassword(password);
			account.setRuolo("utente");
			account.setNome(nome);
			account.setCognome(cognome);
			account.setDataNascita(nascita);
			account.setCellulare(cellulare);
			
			UtenteDAO dao = new UtenteDAO();
			dao.doSave(account);
			
			response.sendRedirect(path);
			
		
		}catch(SQLException e) {
			
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}
	
	
	private boolean exists(String email) throws SQLException{
		
		UtenteDAO dao = new UtenteDAO();
		
		return (dao.doRetrieveByKey(email) != null);
		
			
	}

}

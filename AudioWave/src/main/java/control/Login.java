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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		String pathRedirect = (String) session.getAttribute("path");
		
		String home = "/Home"; 
		
		if(pathRedirect == null || pathRedirect.equals(""))
			pathRedirect = home;   
		
		UtenteBean account;
		
		if((account = recuperaAccount(email, password)) != null) {
			
			session.setAttribute("account", account);
			
			// se a fare il login � l'admin, redirect alla admin home 
			if(account.getRuolo().equals("admin"))
				pathRedirect = request.getContextPath() + "/Amministratore?action=v-prodotti";
			
			response.sendRedirect(pathRedirect);
			
		}else {
			
			request.setAttribute("error", "Le credenziali sono sbagliate, riprovare");
			
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/login.jsp");
			dis.forward(request, response);
			
		}
		
	}
	
	
	private UtenteBean recuperaAccount(String email, String password) {
		
		UtenteDAO dao = new UtenteDAO();
		UtenteBean account = new UtenteBean();
		
		try {
		
			account = dao.doRetrieveByCredentials(email, password);
		
		}catch(SQLException e) {
			
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			account = null;
			
		}
		
		return account;
				
	}

}

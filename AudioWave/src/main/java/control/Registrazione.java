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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getParameter("path");
		request.setAttribute("path", path);
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/registrazione.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nascita = request.getParameter("nascita");
		
		
		String cellulare = request.getParameter("cellulare");
		
		String path = request.getParameter("path");
		System.out.println("Path=" + path);
		
		try {
		
			//controllare se email già presente in DB
			
			if(exists(email)) {
				
				//mandare messaggio a register
				request.setAttribute("messaggio", "Impossibile effettuare la registrazione, email già esistente.");
				//inserire path o no?
				request.setAttribute("path", path);
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/registrazione.jsp");
				dis.forward(request, response);
				return;
				
			}
			
			//System.out.println("Creazione bean");
			UtenteBean account = new UtenteBean();
			account.setEmail(email);
			account.setPassword(password);
			account.setRuolo("utente");
			account.setNome(nome);
			account.setCognome(cognome);
			account.setDataNascita(nascita);
			account.setCellulare(cellulare);
			
			//System.out.println("Salvataggio bean");
			UtenteDAO dao = new UtenteDAO();
			dao.doSave(account);
			
			//System.out.println("Bean salvato");
			
			//System.out.println("Path=" + path);
			
			response.sendRedirect(path);
			
		
		}catch(SQLException e) {
			
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}
	
	
	private boolean exists(String email) throws SQLException{
		
		UtenteDAO dao = new UtenteDAO();
		
		if((dao.doRetrieveByKey(email)) != null)
			return true;
		
		return false;
		
			
	}

}

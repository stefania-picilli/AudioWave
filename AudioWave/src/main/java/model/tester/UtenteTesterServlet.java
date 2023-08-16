package model.tester;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UtenteDAO;
import model.dto.UtenteBean;

/**
 * Servlet implementation class UtenteTesterServlet
 */
@WebServlet("/UtenteTesterServlet")
public class UtenteTesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtenteTesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		UtenteBean bean = new UtenteBean();
		
		bean.setEmail("mooooa@gmail.com");
		bean.setPassword("password");
		bean.setNome("nome");
		bean.setCognome("cognome");
		bean.setDataNascita("2000-10-09");
		bean.setCellulare("cellulare");
		
		System.out.println("bean=" + bean);
		
		
		UtenteDAO dao = new UtenteDAO();
		
		try {
			
			dao.doSave(bean);
			
			UtenteBean beanCaricato = dao.doRetrieveByCredentials("mooooa@gmail.com", "password");
			System.out.println("bean=" + beanCaricato);
			
			
			Collection<UtenteBean> coll = dao.doRetrieveAll("email");
			
			Iterator<UtenteBean> iter = coll.iterator();
			
			System.out.println("Elementi nella collezione: ");
			
			while(iter.hasNext()) {
				
				System.out.println(iter.next());
				
			}
			
			
			
			Boolean bool = dao.doDelete("email@gmail.com");
			if(bool)
				System.out.println("Cancellazione effettuata");
			else
				System.out.println("Cancellazione non effettuata");
			
			
			
			
		}catch(SQLException e) {
			
			System.out.println("Errore nel salvataggio");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

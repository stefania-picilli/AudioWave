package model.tester;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoriaDAO;
import model.dto.CategoriaBean;

/**
 * Servlet implementation class CategoriaTesterServlet
 */
@WebServlet("/CategoriaTesterServlet")
public class CategoriaTesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CategoriaTesterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>hi</title></head>");
		out.println("<body>");
		
		
		
		CategoriaBean bean = new CategoriaBean();
		
		
		bean.setNome("ma che ooooh");
		
		
		System.out.println("bean=" + bean);
		CategoriaDAO dao = new CategoriaDAO();
		
		try {
			
			dao.doSave(bean);
		
			Collection<CategoriaBean> coll = dao.doRetrieveAll();
			
			Iterator<CategoriaBean> iter = coll.iterator();
			
			System.out.println("Elementi nella collezione: ");
			
			while(iter.hasNext()) {
				
				System.out.println(iter.next());
				
			}
			
			
			
			Boolean bool = dao.doDelete(1);
			if(bool)
				System.out.println("Cancellazione effettuata");
			else
				System.out.println("Cancellazione non effettuata");
			
			
		}catch(SQLException e) {
			
			System.out.println("Errore nel salvataggio");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		
		out.println("<p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

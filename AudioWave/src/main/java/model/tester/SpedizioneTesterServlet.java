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

import model.dao.SpedizioneDAO;
import model.dto.SpedizioneBean;

/**
 * Servlet implementation class SpedizioneTesterServlet
 */
@WebServlet("/SpedizioneTesterServlet")
public class SpedizioneTesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpedizioneTesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
SpedizioneBean bean = new SpedizioneBean();
		
		bean.setIdSpedizione("5");
		bean.setCorriere("corriere");
		bean.setDataPartenza("2022-05-29");
		bean.setDataArrivo("2022-06-01");
		bean.setNumeroOrdine(1);
		
		System.out.println("bean=" + bean);
		
		
		SpedizioneDAO dao = new SpedizioneDAO();
		
		try {
			
			dao.doSave(bean);
			
			SpedizioneBean beanCaricato = dao.doRetrieveByKey(bean.getIdSpedizione());
			System.out.println("beanCaricato=" + beanCaricato);
			
			
			Collection<SpedizioneBean> coll = dao.doRetrieveAll();
			
			Iterator<SpedizioneBean> iter = coll.iterator();
			
			System.out.println("Elementi nella collezione: ");
			
			while(iter.hasNext()) {
				
				System.out.println(iter.next());
				
			}
			
			
			
			Boolean bool = dao.doDelete("1");
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

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

import model.dao.ProdottoDAO;
import model.dto.ProdottoBean;

/**
 * Servlet implementation class ProdottoTesterServlet
 */
@WebServlet("/ProdottoTesterServlet")
public class ProdottoTesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottoTesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ProdottoBean bean = new ProdottoBean();
		
		bean.setCodiceProdotto(1);
		bean.setNome("nome");
		bean.setMarca("marca");
		bean.setDescrizione("descrizione");
		bean.setImmagine("img/logo.jpg");
		bean.setPrezzo(30.45);
		bean.setDisponibilita(6);
		bean.setIva(15);
		bean.setCategoriaID(1);
		
		System.out.println("bean=" + bean);
		
		
		ProdottoDAO dao = new ProdottoDAO();
		
		try {
			
			System.out.println("Prezzo max: " + dao.doRetrieveMaxPrezzo());
			
			
			dao.doSave(bean);
			
			ProdottoBean beanCaricato = dao.doRetrieveByKey(bean.getCodiceProdotto() + "");
			System.out.println("beanCaricato=" + beanCaricato);
			
			
			Collection<ProdottoBean> coll = dao.doRetrieveByString("prod");
			
			Iterator<ProdottoBean> iter = coll.iterator();
			
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

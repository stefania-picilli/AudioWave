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

import model.dao.ProdottoAcquistatoDAO;
import model.dto.ProdottoAcquistatoBean;

/**
 * Servlet implementation class ProdottoAcquistatoServlet
 */
@WebServlet("/ProdottoAcquistatoServlet")
public class ProdottoAcquistatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottoAcquistatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProdottoAcquistatoBean bean = new ProdottoAcquistatoBean();
		
		bean.setNumeroOrdine(1);
		bean.setNome("prodotto");
		bean.setMarca("bal al");
		bean.setImmagine("///");
		bean.setPrezzo(53);
		bean.setIva(19);
		bean.setQuantita(1);
		bean.setCodiceProdotto(2);
		
		System.out.println("bean=" + bean);
		
		
		ProdottoAcquistatoDAO dao = new ProdottoAcquistatoDAO();
		
		try {
			
			dao.doSave(bean);
			
			ProdottoAcquistatoBean beanCaricato = dao.doRetrieveByKey(bean.getId(), bean.getNumeroOrdine());
			System.out.println("beanCaricato=" + beanCaricato);
			
			
			Collection<ProdottoAcquistatoBean> coll = dao.doRetrieveAll();
			
			Iterator<ProdottoAcquistatoBean> iter = coll.iterator();
			
			System.out.println("Elementi nella collezione: ");
			
			while(iter.hasNext()) {
				
				System.out.println(iter.next());
				
			}
			
			
			
			Boolean bool = dao.doDelete(2, 1);
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

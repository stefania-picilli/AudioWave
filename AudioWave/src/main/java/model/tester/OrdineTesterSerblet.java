package model.tester;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrdineDAO;
import model.dto.OrdineBean;

/**
 * Servlet implementation class OrdineTesterSerblet
 */
@WebServlet("/OrdineTesterSerblet")
public class OrdineTesterSerblet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdineTesterSerblet() {
        super();
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
		
	OrdineBean bean = new OrdineBean();
		
		
		bean.setData("2022-05-28");
		bean.setIndirizzo("indirizzo");
		bean.setStatoOrdine("Pagato");
		bean.setCostoTotale(45.9);
		bean.setMetodoPagamento("12445");
		bean.setEmail("email@gmail.com");
		
		System.out.println("bean=" + bean);
		
		
		OrdineDAO dao = new OrdineDAO();
		
		try {
			
			List<OrdineBean> list = (List<OrdineBean>) dao.doRetrieveByParameters(null, null, null, "data");
			
			for(OrdineBean o : list)
				System.out.println(o);
			
			
			String data = dao.doRetrievePrimaData();
			
			System.out.println("doRetrievePrimaData(): " + data);
			
			
			Date dataOggi = new Date();
			System.out.println("Data oggi: " + dataOggi);
			
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			System.out.println("SimpleDateFormat: " + date);
			
			int key = dao.doSave(bean);
			System.out.println("Chiave ottenuta=" + key);
			
			OrdineBean beanCaricato = dao.doRetrieveByKey("1");
			System.out.println("beanCaricato=" + beanCaricato);
			
			
			
			
			
			Collection<OrdineBean> coll = dao.doRetrieveAll("");
			
			Iterator<OrdineBean> iter = coll.iterator();
			
			System.out.println("Elementi nella collezione: ");
			
			while(iter.hasNext()) {
				
				System.out.println(iter.next());
				
			}
			
			
			
			Boolean bool = dao.doDelete(3);
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

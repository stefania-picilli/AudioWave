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

import model.dao.ProdottoDAO;
import model.dto.ProdottoBean;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Home.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			
			ProdottoDAO dao = new ProdottoDAO();
			List<ProdottoBean> prodotti = (List<ProdottoBean>) dao.doRetrieveByRand(4);
			
			request.setAttribute("prodotti", prodotti);
			
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/home.jsp");
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

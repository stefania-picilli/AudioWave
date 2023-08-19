package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoriaDAO;
import model.dao.ProdottoDAO;
import model.dto.CategoriaBean;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		try {
		
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			ProdottoDAO prodottoDAO;
		
			List<CategoriaBean> categorie = (List<CategoriaBean>) categoriaDAO.doRetrieveAll("");
    	
			
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/home.jsp");
			dis.forward(request, response);
			
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
			return;
			
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

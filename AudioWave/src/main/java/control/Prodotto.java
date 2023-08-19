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
import model.dto.ProdottoBean;

import helpers.InputFilter;

/**
 * Servlet implementation class Prodotto
 */
@WebServlet("/Prodotto")
public class Prodotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prodotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			String id = InputFilter.filter(request.getParameter("id"));
			
			ProdottoDAO prodottoDAO = new ProdottoDAO();
			ProdottoBean prodotto = prodottoDAO.doRetrieveByKey(id);
			
			if(prodotto == null) {
				
				response.sendError(404);
				return;
				
			}
			
			request.setAttribute("prodotto", prodotto);
			
			int disp = prodotto.getDisponibilita();
			
			if(disp >= 10) { 
				
				request.setAttribute("disponibilita", "Disponibile");
				request.setAttribute("colore", "green-text");
				
			}else if(disp > 1) {
				
				request.setAttribute("disponibilita", "Solo " + disp +  " disponibili");
				request.setAttribute("colore", "yellow-text");
				
			}else if(disp == 1) {
				
				request.setAttribute("disponibilita", "Solo " + disp +  " disponibile");
				request.setAttribute("colore", "yellow-text");
				
			}else {
				
				request.setAttribute("disponibilita", "Non disponibile");
				request.setAttribute("colore", "red-text");
				
			}
			
			RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/prodotto.jsp");
			dis.forward(request, response);
		
		}catch(SQLException e) {
			
			response.sendError(500);
			
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

package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.InputFilter;
import helpers.RicercaProdotti;
import model.dao.ProdottoDAO;
import model.dto.ProdottoBean;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Ricerca.class.getName());
    
	
    public Ricerca() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = InputFilter.filter(request.getParameter("search"));
		String categoria = InputFilter.filter(request.getParameter("categoria"));
	
		Collection<ProdottoBean> coll = null;
		
		try {
		
			if(categoria != null && !categoria.equals("")){
				
				ProdottoDAO prodottoDAO = new ProdottoDAO();
				coll = prodottoDAO.doRetrieveByCategoria(categoria);
				
				request.setAttribute("title", "Categoria: " + categoria);
				request.setAttribute("rimuovicat", 1);
				
				
			}else if(search != null && !search.equals("")) {
			
				ProdottoDAO prodottoDAO = new ProdottoDAO();
				coll = RicercaProdotti.search(prodottoDAO, search);
				
				request.setAttribute("title", "Risultati ricerca: " + search);
			
			}else {
			
				response.sendRedirect(request.getContextPath() + "/Home");
				return;
				
			}
		
		
			List<ProdottoBean> list = (List<ProdottoBean>) coll;
			
			if(list == null || list.isEmpty())
				list = null;
			
			request.setAttribute("prodotti", list);
			
			request.setAttribute("maxPrezzo", RicercaProdotti.maxPrezzo(list));
			
			RequestDispatcher dis;
			dis = getServletContext().getRequestDispatcher("/WEB-INF/views/common/ricerca.jsp");
			
			dis.forward(request, response);
		
		}catch(SQLException e) {
			
			response.sendError(500);	
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	
}

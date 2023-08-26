package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
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

import helpers.InputFilter;

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
				coll = search(prodottoDAO, search);
				
				request.setAttribute("title", "Risultati ricerca: " + search);
			
			}else {
			
				response.sendRedirect(request.getContextPath() + "/Home");
				return;
				
			}
		
		
			List<ProdottoBean> list = (List<ProdottoBean>) coll;
			
			if(list == null || list.isEmpty())
				list = null;
			
			request.setAttribute("prodotti", list);
			
			request.setAttribute("maxPrezzo", maxPrezzo(list));
			
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

	
	private static Collection<ProdottoBean> search(ProdottoDAO prodottoDAO, String search) throws SQLException {
		
		String[] array = search.split(" ");
		
		List<ProdottoBean> list = new LinkedList<>();
		List<ProdottoBean> listTemp = null;
		
		
		for(int i = 0; i < array.length; i++) {
			
			listTemp = (LinkedList<ProdottoBean>) prodottoDAO.doRetrieveByString(array[i]);
			
			if(listTemp == null || listTemp.size() == 0)
				continue;
			
			addItems(list, listTemp);
			
		}
		
		return list;
		
		
	}
	
	
	private static void addItems(List<ProdottoBean> list, List<ProdottoBean> listTemp) {
		
		if(listTemp == null || listTemp.isEmpty())
			return;
		
		int j = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(j >= listTemp.size())
				break;
			
			if(listTemp.get(j).getCodiceProdotto() < list.get(i).getCodiceProdotto()) {
				
				list.add(i, listTemp.get(j));
				j++;
				
				
			}else if(listTemp.get(j).getCodiceProdotto() == list.get(i).getCodiceProdotto()) {
				
				j++;
				
			}
			
		}
		
		//se ci sono altri elementi in listTemp li aggiunge alla fine di list
		
		for(int i = j; i < listTemp.size(); i++)
			list.add(listTemp.get(i));
			
		
	}
	
	
	private static double maxPrezzo(List<ProdottoBean> list) {
		
		if(list == null)
			return 0;
		
		double max = 0;
		
		for(ProdottoBean prodotto : list) 
			if(prodotto.getPrezzoConIva() > max)
				max = prodotto.getPrezzoConIva();
			
		return max;
		
	}
	
	
}

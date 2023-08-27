package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.UtenteBean;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName = "/UserFilter", urlPatterns = {"/Ordine", "/Utente", "/DettagliOrdine"})
public class UserFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public UserFilter() {
        super();
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest hRequest = (HttpServletRequest) request;  
		HttpServletResponse hResponse = (HttpServletResponse) response;  
		
		HttpSession session = hRequest.getSession(true);
		UtenteBean account = (UtenteBean) session.getAttribute("account");
		
		System.out.println("Filtro, account=" + account);
		
		if(account == null || !account.getRuolo().equals("utente")) {
			
			//System.out.println("Prima della chiamata al dispacher");
			
			String path = "";
			
			if(hRequest.getQueryString() != null)
				path = hRequest.getRequestURL().toString() + "?" + hRequest.getQueryString();
			else
				path = hRequest.getRequestURL().toString();
			//System.out.println("Filtro, Path=" + path);
			hRequest.setAttribute("path", path);
			
			/*if(account != null && !account.getRuolo().equals("utente"))
				hRequest.setAttribute("error", "L'account admin non ha accesso alle funzioni utente");*/
			
			hRequest.setAttribute("type", "user");
			
			RequestDispatcher dis = hRequest.getSession().getServletContext().getRequestDispatcher("/WEB-INF/views/common/login.jsp");
			//System.out.println("Dopo recupero dispacher=" + dis);
			dis.forward(request, response);
		
		}else
			// pass the request along the filter chain
			chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

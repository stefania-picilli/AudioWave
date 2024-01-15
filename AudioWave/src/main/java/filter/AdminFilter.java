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
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName = "/AdminFilter", urlPatterns = {"/Amministratore"})
public class AdminFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
        super();
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		/*Non sono necessarie operazioni di chiusura*/
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest hRequest = (HttpServletRequest) request;  
		HttpServletResponse hResponse = (HttpServletResponse) response;  
		
		HttpSession session = hRequest.getSession(true);
		UtenteBean account = (UtenteBean) session.getAttribute("account");
		
		if(account == null || !account.getRuolo().equals("admin")) {
			
			//se l'admin non è già autenticato, si nasconde l'esistenza delle pagine admin
			hResponse.sendError(404);
			return;
		
		}else
			// pass the request along the filter chain
			chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/*Non sono necessarie operazioni di inizializzazione*/
	}

}

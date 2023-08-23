package control;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.dao.CategoriaDAO;
import model.dto.CategoriaBean;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(MyContextListener.class.getName());

	
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	CategoriaDAO categoriaDAO = new CategoriaDAO();
    	ServletContext sc = sce.getServletContext();
    	
    	try {
    		
    		List<CategoriaBean> categorie = (List<CategoriaBean>) categoriaDAO.doRetrieveAll();
    		sc.setAttribute("categorie", categorie);
    	
    	}catch(SQLException e) {
    		
    		logger.warning(e.getMessage() + "\n" + e.getStackTrace());
    		return;
    	}
		
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
        
    	logger.info("Destroyed: " + sce.getServletContext().getServerInfo());
    	
    }
    
    
}

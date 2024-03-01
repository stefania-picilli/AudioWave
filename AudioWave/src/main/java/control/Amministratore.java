package control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import helpers.InputFilter;
import helpers.RicercaProdotti;
import model.dao.CategoriaDAO;
import model.dao.OrdineDAO;
import model.dao.ProdottoAcquistatoDAO;
import model.dao.ProdottoDAO;
import model.dao.SpedizioneDAO;
import model.dao.UtenteDAO;
import model.dto.CategoriaBean;
import model.dto.OrdineBean;
import model.dto.ProdottoAcquistatoBean;
import model.dto.ProdottoBean;
import model.dto.SpedizioneBean;
import model.dto.UtenteBean;

/**
 * Servlet implementation class Amministratore
 */
@WebServlet("/Amministratore")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)   // 50MB
public class Amministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Amministratore.class.getName());
	private static final String SAVE_DIR = "resources/images/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Amministratore() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			String action = request.getParameter("action");
			
			if(action.equals("c-prodotto")) {
				
				CategoriaDAO dao = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) dao.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/creaProdotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("v-prodotti")) {
				
				ProdottoDAO dao = new ProdottoDAO();
				List<ProdottoBean> prodotti = (List<ProdottoBean>) dao.doRetrieveAll();
				request.setAttribute("prodotti", prodotti);
				
				CategoriaDAO daoC = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) daoC.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveMaxPrezzo();
				request.setAttribute("maxPrezzo", prodotto.getPrezzoConIva());
				
				request.setAttribute("title", "Prodotti");
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/prodotti.jsp");
				dis.forward(request, response);
				
			}else if(action.equals("v-prodotto")){
				
				String codiceProdotto = request.getParameter("codice");
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveByKey(codiceProdotto);
				
				if(prodotto == null) {
					
					request.setAttribute("admin", "1");
					response.sendError(404);
					return;
					
				}
				
				
				request.setAttribute("prodotto", prodotto);
				
				
				int disp = prodotto.getDisponibilita();
				String disponibilita = "";
				String colore = "";
				
				disponibilita = getDisponibilita(disp);
				colore = getColore(disp);
				
				
				
				request.setAttribute("disponibilita", disponibilita);
				request.setAttribute("colore", colore);
				
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/prodotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("m-prodotto")){
				
				String codiceProdotto = request.getParameter("codice");
				ProdottoDAO daoP = new ProdottoDAO();
				ProdottoBean prodotto = daoP.doRetrieveByKey(codiceProdotto);
				request.setAttribute("prodotto", prodotto);
				
				CategoriaDAO daoC = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) daoC.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/modificaProdotto.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("v-ordini")) {
				
				OrdineDAO daoO = new OrdineDAO();
				String dataIniziale = daoO.doRetrievePrimaData();
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dataFinale = simpleDateFormat.format(new Date());
					
				List<OrdineBean> ordini = (List<OrdineBean>) daoO.doRetrieveAll();
	
				if(ordini != null && !ordini.isEmpty())
					request.setAttribute("ordini", ordini);
				
				UtenteDAO daoAcc = new UtenteDAO();
				List<UtenteBean> utenti = (List<UtenteBean>) daoAcc.doRetrieveAll(); 
				
				request.setAttribute("utenti", utenti);
				request.setAttribute("da", dataIniziale);
				request.setAttribute("a", dataFinale);
				
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ordini.jsp");
				dis.forward(request, response);
				
			}else if(action.equals("v-ordine")) {
				
				String num = request.getParameter("num");
				
				OrdineDAO ordDAO = new OrdineDAO();
				OrdineBean ordine = ordDAO.doRetrieveByKey(num);
				
				if(ordine == null) {
					
					request.setAttribute("admin", "1");
					response.sendError(404);
					return;
					
				}
				
				String email = ordine.getEmail();
				UtenteDAO utDAO = new UtenteDAO();
				UtenteBean utente = utDAO.doRetrieveByKey(email);
				
				ProdottoAcquistatoDAO prodDAO = new ProdottoAcquistatoDAO();
				List<ProdottoAcquistatoBean> prodotti = (List<ProdottoAcquistatoBean>) prodDAO.doRetrieveByOrdine(num);
				
				SpedizioneDAO spedDAO = new SpedizioneDAO();
				SpedizioneBean spedizione = spedDAO.doRetrieveByOrdine(num);
				
				request.setAttribute("prodotti", prodotti);
				request.setAttribute("ordine", ordine);
				request.setAttribute("utente", utente);
				request.setAttribute("spedizione", spedizione);
				
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ordine.jsp");
				dis.forward(request, response);
				
				
			}else if(action.equals("ricerca")) {
				
				
				
				String search = InputFilter.filter(request.getParameter("search"));
				
				Collection<ProdottoBean> coll = null;
				
				if(search != null && !search.equals("")) {
				
					ProdottoDAO prodottoDAO = new ProdottoDAO();
					coll = RicercaProdotti.search(prodottoDAO, search);
					
					request.setAttribute("title", "Risultati ricerca: " + search);
				
				}else {
				
					response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
					return;
					
				}
			
			
				List<ProdottoBean> list = (List<ProdottoBean>) coll;
				
				if(list == null || list.isEmpty())
					list = null;
				
				request.setAttribute("prodotti", list);
				request.setAttribute("maxPrezzo", RicercaProdotti.maxPrezzo(list));
				
				CategoriaDAO daoC = new CategoriaDAO();
				List<CategoriaBean> categorie = (List<CategoriaBean>) daoC.doRetrieveAll();
				request.setAttribute("categorie", categorie);
				
				RequestDispatcher dis;
				dis = getServletContext().getRequestDispatcher("/WEB-INF/views/admin/prodotti.jsp");
				
				dis.forward(request, response);
				
				
			}
			
		
		}catch(Exception e) {
			
			request.setAttribute("admin", "1");
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
		
			String action = request.getParameter("action");
			
			
			if(action.equals("c-prodotto")) {
				
				String nome = request.getParameter("nome");
				String marca = request.getParameter("marca");
				String descrizione = request.getParameter("descrizione");
				double prezzo = Double.parseDouble(request.getParameter("prezzo"));
				int disponibilita = Integer.parseInt(request.getParameter("disponibilita"));
				double iva = Double.parseDouble(request.getParameter("iva"));
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				
				// Get the file part from the request
	            Part filePart = request.getPart("immagine");

	            // Generate a unique file name
	            String fileName = UUID.randomUUID().toString() + extractFileName(filePart);
	            
	            // Define the directory where the file will be stored
	            String uploadDir = getServletContext().getRealPath(SAVE_DIR);

	            // Create the directory if it doesn't exist
	            File dir = new File(uploadDir);
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }

	            // Save the file to the specified directory
	            String filePath = uploadDir + File.separator + fileName;
	            filePath = filePath.replace("\\", "/");
	            filePart.write(filePath);
				
				
				ProdottoBean prodotto = new ProdottoBean();
				prodotto.setNome(nome);
				prodotto.setImmagine(SAVE_DIR + fileName);
				prodotto.setMarca(marca);
				prodotto.setDescrizione(descrizione);
				prodotto.setPrezzo(prezzo);
				prodotto.setDisponibilita(disponibilita);
				prodotto.setIva(iva);
				prodotto.setCategoriaID(categoria);
				
				
				ProdottoDAO dao = new ProdottoDAO();
				dao.doSave(prodotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}else if(action.equals("m-prodotto")) {
				
				String codice = request.getParameter("id");		
				String nome = request.getParameter("nome");
				String marca = request.getParameter("marca");
				String descrizione = request.getParameter("descrizione");
				String prezzo = request.getParameter("prezzo");
				String disponibilita = request.getParameter("disponibilita");
				String iva = request.getParameter("iva");
				String categoria = request.getParameter("categoria");
				
				
				ProdottoDAO dao = new ProdottoDAO();
				ProdottoBean prodotto = new ProdottoBean();
				
				prodotto.setCodiceProdotto(Integer.parseInt(codice));
				prodotto.setNome(nome);
				prodotto.setImmagine(null);
				prodotto.setMarca(marca);
				prodotto.setDescrizione(descrizione);
				prodotto.setPrezzo(Double.parseDouble(prezzo));
				prodotto.setDisponibilita(Integer.parseInt(disponibilita));
				prodotto.setIva(Double.parseDouble(iva));
				prodotto.setCategoriaID(Integer.parseInt(categoria));
			
				Part filePart = request.getPart("immagine");
				
				
	            String fileName = extractFileName(filePart);
				
				if(fileName != null && !fileName.equals("")) {
					
					fileName = UUID.randomUUID().toString() + fileName;

		            // Define the directory where the file will be stored
		            String uploadDir = getServletContext().getRealPath(SAVE_DIR);

		            // Create the directory if it doesn't exist
		            File dir = new File(uploadDir);
		            if (!dir.exists()) {
		                dir.mkdirs();
		            }

		            // Save the file to the specified directory
		            String filePath = uploadDir + File.separator + fileName;
		            filePath = filePath.replace("\\", "/");
		            filePart.write(filePath);
		            
		            prodotto.setImmagine(SAVE_DIR + fileName);
					
				}
				
				
				dao.updateProdotto(prodotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
				
			}else if(action.equals("m-spedizione")) {
				
				String corriere = request.getParameter("corriere");
				String dataPartenza = request.getParameter("data-partenza");
				String dataArrivo = request.getParameter("data-arrivo");
				int numeroOrdine = Integer.parseInt(request.getParameter("numeroOrdine"));
				
				
				SpedizioneBean spedizione = new SpedizioneBean();
				
				spedizione.setCorriere(corriere);
				spedizione.setDataPartenza(dataPartenza);
				spedizione.setDataArrivo(dataArrivo);
				spedizione.setNumeroOrdine(numeroOrdine);
				
				SpedizioneDAO dao = new SpedizioneDAO();
				dao.doSave(spedizione);
				
				OrdineDAO ordDAO = new OrdineDAO();
				ordDAO.doUpdateStato(numeroOrdine, "Spedito");
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}else if(action.equals("r-prodotto")) {
				
				String codiceProdotto = request.getParameter("codice");
				
				ProdottoDAO dao = new ProdottoDAO();
				dao.doDelete(codiceProdotto);
				
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
				
			}else {
				response.sendRedirect(request.getContextPath() + "/Amministratore?action=v-prodotti");
			}
		}catch(Exception e) {
			
			request.setAttribute("admin", "1");
			response.sendError(500);
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
			
		}
		
	}

	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }	
	
	
	private static String getDisponibilita(int disp) {
		
		if(disp >= 5)
			return "Disponibile";
		else if(disp > 1) 
			return "Solo " + disp +  " disponibili";
		else if(disp == 1) 
			return "Solo " + disp +  " disponibile";
		else 
			return "Non disponibile";
			
		
	} 
	
	private static String getColore(int disp) {
		
		if(disp >= 5)
			return "green-text";
		else if(disp > 1) 
			return "yellow-text";
		else if(disp == 1) 
			return "yellow-text";
		else
			return "red-text";
		
		
	}
	
	
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.ProdottoBean;

public class ProdottoDAO {

	public static final String TABLE_NAME = "Prodotto";
	private static DataSource ds;
	private static final Logger logger = Logger.getLogger(ProdottoDAO.class.getName());

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		}
	}
	
	
	

	public void doSave(ProdottoBean prodotto) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + ProdottoDAO.TABLE_NAME
				+ " (nome, marca, descrizione, immagine, tag, prezzo, disponibilita, IVA, categoriaID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(insertSQL);
			ps.setString(1, prodotto.getNome());
			ps.setString(2, prodotto.getMarca());
			ps.setString(3, prodotto.getDescrizione());
			ps.setString(4, prodotto.getImmagine());
			ps.setString(5, prodotto.getTag());
			ps.setDouble(6, prodotto.getPrezzo());
			ps.setInt(7, prodotto.getDisponibilita());
			ps.setDouble(8, prodotto.getIva());
			ps.setInt(9, prodotto.getCategoriaID());
			
			
			ps.executeUpdate();

			
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		
		
		
	}

	public boolean doDelete(String codiceProdotto) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + ProdottoDAO.TABLE_NAME
				+ " WHERE codiceProdotto = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(deleteSQL);
			
			ps.setString(1, codiceProdotto);
			
			result = ps.executeUpdate();

			
			
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return (result != 0);
		
	}

	public ProdottoBean doRetrieveByKey(String codiceProdotto) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		ProdottoBean bean = null;

		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + " WHERE codiceProdotto = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, codiceProdotto);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setTag(rs.getString("tag"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
			}
			


		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return bean;
		
		
		
	}
	
	
	
	
	
	public Collection<ProdottoBean> doRetrieveByString(String search) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Collection<ProdottoBean> prodotti = new LinkedList<>();


		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + 
				   " WHERE nome LIKE ? OR marca LIKE ? OR tag LIKE ?" + 
				   	" ORDER BY codiceProdotto";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			
			ps.setString(1, search + "%");
			ps.setString(2, search + "%");
			ps.setString(3, "%" + search + ",%");
			
			
			rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoBean bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTag(rs.getString("tag"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
				prodotti.add(bean);
				
			}
			
			if(prodotti.isEmpty())
				prodotti = null;
			

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
	
		return prodotti;
		
		
		
	}
	
	
	
	public Collection<ProdottoBean> doRetrieveByCategoria(String categoria) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<ProdottoBean> prodotti = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + " AS P, " + CategoriaDAO.TABLE_NAME + " AS C" +
						   " WHERE P.categoriaID = C.ID AND C.nome = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, categoria);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoBean bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTag(rs.getString("tag"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
				prodotti.add(bean);
				
			}
			

			if(prodotti.isEmpty())
				prodotti = null;

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return prodotti;
		
		
		
	}
	
	public Collection<ProdottoBean> doRetrieveByRand(int limit) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<ProdottoBean> prodotti = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME +
						   " ORDER BY RAND() " +
						   "LIMIT ?";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setInt(1, limit);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoBean bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTag(rs.getString("tag"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
				prodotti.add(bean);
				
			}
			

			if(prodotti.isEmpty())
				prodotti = null;

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return prodotti;
		
		
		
	}
	
	
	public void decrementaDisp(int codiceProdotto, int quantita) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;


		String selectSQL = "UPDATE " + ProdottoDAO.TABLE_NAME
							+ " SET disponibilita = disponibilita - ?"
							+ " WHERE codiceProdotto = ?;";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setInt(1, quantita);
			ps.setInt(2, codiceProdotto);
			
			ps.executeUpdate();
			
			
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		

		
	}
	
	
	public void updateProdotto(ProdottoBean prodotto) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		String updateSQL = "";
		
		
		if(prodotto.getImmagine() == null) {
			
			updateSQL =  "UPDATE " + ProdottoDAO.TABLE_NAME
					+ " SET nome = ?, marca = ?, descrizione = ?, tag = ?, prezzo = ?, disponibilita = ?, iva = ?, categoriaID = ?"
					+ " WHERE codiceProdotto = ?;";
			
		}else {

			updateSQL =  "UPDATE " + ProdottoDAO.TABLE_NAME
					+ " SET nome = ?, marca = ?, descrizione = ?, tag = ?, prezzo = ?, disponibilita = ?, iva = ?, categoriaID = ?, immagine = ?"
					+ " WHERE codiceProdotto = ?;";

		}
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(updateSQL);
			
			ps.setString(1, prodotto.getNome());
			ps.setString(2, prodotto.getMarca());
			ps.setString(3, prodotto.getDescrizione());
			ps.setString(4, prodotto.getTag());
			ps.setDouble(5, prodotto.getPrezzo());
			ps.setInt(6, prodotto.getDisponibilita());
			ps.setDouble(7, prodotto.getIva());
			ps.setInt(8, prodotto.getCategoriaID());
			
			if(prodotto.getImmagine() != null) {
				ps.setString(9, prodotto.getImmagine());
				ps.setInt(10, prodotto.getCodiceProdotto());
			}else
				ps.setInt(9, prodotto.getCodiceProdotto());
			
			ps.executeUpdate();

			
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		
		
		
	}
	
	
	public Collection<ProdottoBean> doRetrieveAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<ProdottoBean> prodotti = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoBean bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTag(rs.getString("tag"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
				prodotti.add(bean);
			
			}

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return prodotti;
		
		
		
	}
	
	
	public ProdottoBean doRetrieveMaxPrezzo() throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		ProdottoBean bean = null;

		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + " WHERE prezzo = (SELECT MAX(prezzo) FROM " + ProdottoDAO.TABLE_NAME + " );";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean = new ProdottoBean();

				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTag(rs.getString("tag"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisponibilita(rs.getInt("disponibilita"));
				bean.setIva(rs.getDouble("iva"));
				bean.setCategoriaID(rs.getInt("categoriaID"));
				
				
			}
			


		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		
		return bean;
		
		
		
	}
	
	
}

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

import model.dto.ProdottoAcquistatoBean;


public class ProdottoAcquistatoDAO {

	public static final String TABLE_NAME = "ProdottoAcquistato";
	private static DataSource ds;
	private static final Logger logger = Logger.getLogger(ProdottoAcquistatoDAO.class.getName());

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		}
	}
	

	public void doSave(ProdottoAcquistatoBean prodotto) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + ProdottoAcquistatoDAO.TABLE_NAME
				+ " (numeroOrdine, nome, marca, immagine, prezzo, IVA, quantita, codiceProdotto) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(insertSQL);
			
			ps.setInt(1, prodotto.getNumeroOrdine());
			ps.setString(2, prodotto.getNome());
			ps.setString(3, prodotto.getMarca());
			ps.setString(4, prodotto.getImmagine());
			ps.setDouble(5, prodotto.getPrezzo());
			ps.setDouble(6, prodotto.getIva());
			ps.setInt(7, prodotto.getQuantita());
			ps.setInt(8, prodotto.getCodiceProdotto());
			
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

	public boolean doDelete(int id, int numeroOrdine) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + ProdottoAcquistatoDAO.TABLE_NAME
				+ " WHERE id = ? AND numeroOrdine = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(deleteSQL);
			
			ps.setInt(1, id);
			ps.setInt(2, numeroOrdine);
			
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

	public ProdottoAcquistatoBean doRetrieveByKey(int id, int numeroOrdine) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		ProdottoAcquistatoBean bean = new ProdottoAcquistatoBean();

		String selectSQL = "SELECT * FROM " + ProdottoAcquistatoDAO.TABLE_NAME + " WHERE id = ? AND numeroOrdine = ?";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setInt(1, id);
			ps.setInt(2, numeroOrdine);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean.setId(rs.getInt("id"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setIva(rs.getDouble("iva"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				
			
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
	
	
	public Collection<ProdottoAcquistatoBean> doRetrieveByOrdine(String numeroOrdine) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<ProdottoAcquistatoBean> accounts = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + ProdottoAcquistatoDAO.TABLE_NAME + " WHERE numeroOrdine = ?;";


		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, numeroOrdine);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoAcquistatoBean bean = new ProdottoAcquistatoBean();

				bean.setId(rs.getInt("id"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setIva(rs.getDouble("iva"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				
				
				accounts.add(bean);
			
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
		
		return accounts;
		
		
		
	}
	
	
	public Collection<ProdottoAcquistatoBean> doRetrieveAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<ProdottoAcquistatoBean> accounts = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + ProdottoAcquistatoDAO.TABLE_NAME;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				ProdottoAcquistatoBean bean = new ProdottoAcquistatoBean();

				bean.setId(rs.getInt("id"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setIva(rs.getDouble("iva"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setCodiceProdotto(rs.getInt("codiceProdotto"));
				
				
				accounts.add(bean);
			
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
		
		return accounts;
		
		
		
	}
	
	
	
}

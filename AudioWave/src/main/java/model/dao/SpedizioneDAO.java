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

import model.dto.SpedizioneBean;

public class SpedizioneDAO {

	
	private static DataSource ds;
	private static final Logger logger = Logger.getLogger(SpedizioneDAO.class.getName());

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		}
	}
	
	public final static String TABLE_NAME = "Spedizione";

	public void doSave(SpedizioneBean spedizione) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + SpedizioneDAO.TABLE_NAME
				+ " (idSpedizione, corriere, dataPartenza, dataArrivo,  numeroOrdine) VALUES (?, ?, ?, ?, ?);";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(insertSQL);
			
			ps.setString(1, spedizione.getIdSpedizione());
			ps.setString(2, spedizione.getCorriere());
			ps.setString(3, spedizione.getDataPartenza());
			ps.setString(4, spedizione.getDataArrivo());
			ps.setInt(5, spedizione.getNumeroOrdine());
			
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

	public boolean doDelete(String idSpedizione) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + SpedizioneDAO.TABLE_NAME
				+ " WHERE idSpedizione = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(deleteSQL);
			
			ps.setString(1, idSpedizione);
			
			
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

	public SpedizioneBean doRetrieveByKey(String idSpedizione) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		SpedizioneBean bean = new SpedizioneBean();

		String selectSQL = "SELECT * FROM " + SpedizioneDAO.TABLE_NAME + " WHERE idSpedizione = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, idSpedizione);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				

				bean.setIdSpedizione(rs.getString("idSpedizione"));
				bean.setCorriere(rs.getString("corriere"));
				bean.setDataPartenza(rs.getString("dataPartenza"));
				bean.setDataArrivo(rs.getString("dataArrivo"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				
			
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
	
	
	public SpedizioneBean doRetrieveByOrdine(String numeroOrdine) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		SpedizioneBean bean = null;

		String selectSQL = "SELECT * FROM " + SpedizioneDAO.TABLE_NAME + " WHERE numeroOrdine = ?";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, numeroOrdine);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean = new SpedizioneBean();

				bean.setIdSpedizione(rs.getString("idSpedizione"));
				bean.setCorriere(rs.getString("corriere"));
				bean.setDataPartenza(rs.getString("dataPartenza"));
				bean.setDataArrivo(rs.getString("dataArrivo"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				
			
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
	
	
	public Collection<SpedizioneBean> doRetrieveAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<SpedizioneBean> accounts = new LinkedList<SpedizioneBean>();

		String selectSQL = "SELECT * FROM " + SpedizioneDAO.TABLE_NAME;


		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				SpedizioneBean bean = new SpedizioneBean();

				bean.setIdSpedizione(rs.getString("idSpedizione"));
				bean.setCorriere(rs.getString("corriere"));
				bean.setDataPartenza(rs.getString("dataPartenza"));
				bean.setDataArrivo(rs.getString("dataArrivo"));
				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				
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

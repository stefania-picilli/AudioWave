package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.OrdineBean;


public class OrdineDAO {
	
	public static final String TABLE_NAME = "Ordine";
	private static DataSource ds;
	private static final Logger logger = Logger.getLogger(OrdineDAO.class.getName());

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		}
	}

	
	public int doSave(OrdineBean ordine) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Statement stm = null;

		String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME
				+ " (data, indirizzo, statoOrdine, costoTotale, metodoPagamento, email) VALUES (?, ?, ?, ?, ?, ?);";

		try {
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(insertSQL);
			
			ps.setString(1, ordine.getData());
			ps.setString(2, ordine.getIndirizzo());
			ps.setString(3, ordine.getStatoOrdine());
			ps.setDouble(4, ordine.getCostoTotale());
			ps.setString(5, ordine.getMetodoPagamento());
			ps.setString(6, ordine.getEmail());
			
			ps.executeUpdate();

			
			stm = con.createStatement();
			String selectSQL = "SELECT LAST_INSERT_ID();";
			
			ResultSet rs = stm.executeQuery(selectSQL);
			
			rs.next();
			
			con.commit();
			
			return rs.getInt(1);
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				
				try {
					if (con != null)
						con.close();
				}finally {
					if (stm != null)
						stm.close();
				}
			}
		}
		
		
		
		
	}

	
	public boolean doDelete(int numeroOrdine) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + OrdineDAO.TABLE_NAME
				+ " WHERE numeroOrdine = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(deleteSQL);
			
			ps.setInt(1, numeroOrdine);
			
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

	public OrdineBean doRetrieveByKey(String numeroOrdine) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		OrdineBean bean = new OrdineBean();

		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME + " WHERE numeroOrdine = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, numeroOrdine);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				

				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setData(rs.getString("data"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setStatoOrdine(rs.getString("statoOrdine"));
				bean.setCostoTotale(rs.getDouble("costoTotale"));
				bean.setMetodoPagamento(rs.getString("metodoPagamento"));
				bean.setEmail(rs.getString("email"));
				
			
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
	
	public Collection<OrdineBean> doRetrieveByAccount(String email) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<OrdineBean> accounts = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME + " WHERE email = ?";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				OrdineBean bean = new OrdineBean();

				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setData(rs.getString("data"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setStatoOrdine(rs.getString("statoOrdine"));
				bean.setCostoTotale(rs.getDouble("costoTotale"));
				bean.setMetodoPagamento(rs.getString("metodoPagamento"));
				bean.setEmail(rs.getString("email"));
				
				
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
	
	
	
	public Collection<OrdineBean> doRetrieveAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<OrdineBean> accounts = new LinkedList<>();

		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME;


		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				OrdineBean bean = new OrdineBean();

				bean.setNumeroOrdine(rs.getInt("numeroOrdine"));
				bean.setData(rs.getString("data"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setStatoOrdine(rs.getString("statoOrdine"));
				bean.setCostoTotale(rs.getDouble("costoTotale"));
				bean.setMetodoPagamento(rs.getString("metodoPagamento"));
				bean.setEmail(rs.getString("email"));
				
				
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
	

	
	public String doRetrievePrimaData() throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		String selectSQL = "SELECT MIN(data) as data FROM " + OrdineDAO.TABLE_NAME;
		String data = "";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
		
				data = rs.getString("data");
			
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
		
		return data;
		
		
		
	}
	
	public boolean doUpdateStato(int numeroOrdine, String nuovoStato) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String updateSQL = "UPDATE Ordine"
						+ " SET statoOrdine = ?"
						+ " WHERE numeroOrdine = ?";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(updateSQL);

			ps.setString(1, nuovoStato);
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
	
	
}

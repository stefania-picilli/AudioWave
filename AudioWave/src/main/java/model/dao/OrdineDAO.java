package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.OrdineBean;


public class OrdineDAO {
	
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public final static String TABLE_NAME = "Ordine";

	public int doSave(OrdineBean ordine) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

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

			
			Statement stm = con.createStatement();
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
				if (con != null)
					con.close();
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
	
	public Collection<OrdineBean> doRetrieveByAccount(String email, String order) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<OrdineBean> accounts = new LinkedList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME + " WHERE email = ?";
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

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
	
	
	
	public Collection<OrdineBean> doRetrieveAll(String order) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<OrdineBean> accounts = new LinkedList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

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
	
	public Collection<OrdineBean> doRetrieveByParameters(String email, String da, String a, String order) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<OrdineBean> accounts = new LinkedList<OrdineBean>();
		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME; 
		int caso = 0;
		
		if((da != "" && da != null && a != null && a != "") && (email != "" && email != null)) { 
			
			selectSQL += " WHERE email = ? AND data BETWEEN ? AND ?";
			caso = 1;
			
		}else if(da != "" && da != null && a != "" && a != null) { 
			
			selectSQL += " WHERE data BETWEEN ? AND ?";
			caso = 2;
			
		}else if(email != "" && email != null) {
			
			selectSQL += " WHERE email = ?";
			caso = 3; 
			
		}
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);
			
			if(caso == 1) {
				
				ps.setString(1, email);
				ps.setString(2, da);
				ps.setString(3, a);
				
			}else if(caso == 2) {
				
				ps.setString(1, da);
				ps.setString(2, a);
				
			}else if(caso == 3){
				
				ps.setString(1, email);
				
			}
			
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

		OrdineBean bean = new OrdineBean();

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
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.UtenteBean;

public class UtenteDAO {

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
	
	
	public final static String TABLE_NAME = "Utente";

	public void doSave(UtenteBean account) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + UtenteDAO.TABLE_NAME
				+ " (email, password, ruolo, nome, cognome, dataDiNascita, cellulare) VALUES (?, SHA2(?, 0), ?, ?, ?, ?, ?);";

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(insertSQL);
			ps.setString(1, account.getEmail());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getRuolo());
			ps.setString(4, account.getNome());
			ps.setString(5, account.getCognome());
			ps.setString(6, account.getDataNascita());
			ps.setString(7, account.getCellulare());
			
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

	public boolean doDelete(String email) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + UtenteDAO.TABLE_NAME
				+ " WHERE email = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(deleteSQL);
			
			ps.setString(1, email);
			
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

	public UtenteBean doRetrieveByKey(String email) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		UtenteBean bean = null;

		String selectSQL = "SELECT * FROM " + UtenteDAO.TABLE_NAME + " WHERE email = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean = new UtenteBean();

				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setRuolo(rs.getString("ruolo"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataDiNascita"));
				bean.setCellulare(rs.getString("cellulare"));
				
			
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
	
	
	public UtenteBean doRetrieveByCredentials(String email, String password) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		UtenteBean bean = null;

		String selectSQL = "SELECT * FROM " + UtenteDAO.TABLE_NAME + " WHERE email = ? AND password = SHA2(?, 0)";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean = new UtenteBean();
				
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setRuolo(rs.getString("ruolo"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataDiNascita"));
				bean.setCellulare(rs.getString("cellulare"));
				
			
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
	
	
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<UtenteBean> accounts = new LinkedList<UtenteBean>();

		String selectSQL = "SELECT * FROM " + UtenteDAO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				UtenteBean bean = new UtenteBean();

				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setRuolo(rs.getString("ruolo"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataDiNascita"));
				bean.setCellulare(rs.getString("cellulare"));
				
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

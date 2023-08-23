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

import control.Ricerca;
import model.dto.CategoriaBean;



public class CategoriaDAO {
	
	
	private static DataSource ds;
	private static final Logger logger = Logger.getLogger(CategoriaDAO.class.getName());

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/AudioWave");

		} catch (NamingException e) {
			logger.warning(e.getMessage() + "\n" + e.getStackTrace());
		}
	}
	
	public final static String TABLE_NAME = "Categoria";
	

	public void doSave(CategoriaBean categoria) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + CategoriaDAO.TABLE_NAME
				+ " (id, nome) VALUES (?, ?);";

		try {
			
			con = ds.getConnection();
			
			ps = con.prepareStatement(insertSQL);
			
			ps.setInt(1, categoria.getId());
			ps.setString(2, categoria.getNome());
			
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

	public boolean doDelete(int id) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		String deleteSQL = "DELETE FROM " + CategoriaDAO.TABLE_NAME
				+ " WHERE id = ?;";

		int result = 0;
		
		try {
			
			con = ds.getConnection();
			
			
			ps = con.prepareStatement(deleteSQL);
			
			ps.setInt(1, id);
			
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

	public CategoriaBean doRetrieveByKey(int id) throws SQLException{
		
		
		Connection con = null;
		PreparedStatement ps = null;

		CategoriaBean bean = new CategoriaBean();

		String selectSQL = "SELECT * FROM " + CategoriaDAO.TABLE_NAME + " WHERE id = ?";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				bean.setNome(rs.getString("nome"));
				bean.setId(rs.getInt("id"));
			
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
	
	public Collection<CategoriaBean> doRetrieveAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;

		Collection<CategoriaBean> accounts = new LinkedList<CategoriaBean>();

		String selectSQL = "SELECT * FROM " + CategoriaDAO.TABLE_NAME;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				CategoriaBean bean = new CategoriaBean();

				bean.setNome(rs.getString("nome"));
				bean.setId(rs.getInt("id"));
				
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

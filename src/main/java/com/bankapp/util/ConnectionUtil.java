package com.bankapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	public static Connection getDbConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "system", "oracle");
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();

		}
		return con;
	}

	public  static  void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	public  static  void closeStatement(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	public  static  void closePrepareStatement(PreparedStatement pstmt,ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
		if(pstmt !=null)
			pstmt.close();
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
		public  static  void closeStatePrepareStatement( Statement pstmt,ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
			if(pstmt !=null)
				pstmt.close();
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
	}
		public  static  void closeResultSet(ResultSet rset, PreparedStatement pstmt,ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
			if(rset !=null)
				rset.close();
			if(pstmt !=null)
				pstmt.close();
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
}

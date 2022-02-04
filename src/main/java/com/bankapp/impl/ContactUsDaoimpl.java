package com.bankapp.impl;

import com.bankapp.model.ContactUs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.util.ConnectionUtil;

public class ContactUsDaoimpl {

	public boolean insertMessage(String name, String email, String message) throws SQLException {

		String query = "insert into contact_us(user_name,email,message) values(?,?,?)";
		Connection con = null;
		boolean flag = false;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, message);
			flag = true;
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();

			}
		}
		return flag;
	}

	public List<ContactUs> allDetails() throws SQLException {
		List<ContactUs> list = new ArrayList<>();
		Connection con = null;
		String validateQuery = "select user_name,email,message from  ContactUs ";
		ResultSet rs = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(validateQuery);

			while (rs.next()) {
				ContactUs contact = new ContactUs(rs.getString("user_name"), rs.getString("email"),
						rs.getString("message"));
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();

			}
		}

		return list;
	}
}

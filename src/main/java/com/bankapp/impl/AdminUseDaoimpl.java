package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.AdminUseDao;
import com.bankapp.logger.Logger;
import com.bankapp.model.AdminUse;
import com.bankapp.util.ConnectionUtil;

public class AdminUseDaoimpl implements AdminUseDao {
	@Override
	public boolean getDescriptionId(double descriptionId, double rateOfInterest) throws SQLException {
		String query = "update admin_use set INTEREST_RATE=? where DESCRIPTION_ID=?";
		Connection con = null;
		boolean flag = false;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setDouble(1, rateOfInterest);
			statement.setDouble(2, descriptionId);
			flag = true;
			statement.executeUpdate();

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
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

	@Override
	public List<AdminUse> allDetails() throws SQLException {
		List<AdminUse> list = new ArrayList<>();
		Connection con = null;

		String validateQuery = "select category_name,category_type,description,description_id,interest_rate from admin_use order by description_id";

		AdminUse adminuse = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(validateQuery);

			while (rs.next()) {
				adminuse = new AdminUse(rs.getString("category_name"), rs.getString("category_type"),
						rs.getString("description"), rs.getDouble("description_id"), rs.getDouble("interest_rate"));
				list.add(adminuse);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			 ConnectionUtil.closeStatement(rs, statement, con);
		}
		return list;
	}

	public List<AdminUse> interestRate() throws SQLException {
		List<AdminUse> list = new ArrayList<>();
		Connection con = null;
		String validateQuery = "select category_name,category_type,description,description_id,interest_rate  from admin_use order by description_id";
		ResultSet rs = null;
		Statement statement = null;
		AdminUse adminuse = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(validateQuery);

			while (rs.next()) {
				adminuse = new AdminUse(rs.getString("category_name"), rs.getString("category_type"),
						rs.getString("description"), rs.getDouble("description_id"), rs.getDouble("interest_rate"));
				list.add(adminuse);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(rs, statement, con);
		}

		return list;
	}

}

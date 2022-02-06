package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.LoansDao;
import com.bankapp.model.Loans;
import com.bankapp.util.ConnectionUtil;

public class LoansDaoimpl implements LoansDao {
	@Override
	public double getInterest(double descriptionId) throws SQLException {
		String updateQuery = "select INTEREST_RATE from ADMIN_USE where DESCRIPTION_ID=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setDouble(1, descriptionId);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getDouble("INTEREST_RATE");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return 0;
	}

	@Override
	public long PersonalLoan(Loans loan) throws SQLException {
		String que = "select  loan_acc.nextval from dual";
		String query = "INSERT INTO LOANS (ACCOUNT_NUMBER,ACC_HOLDER_NAME,DOB,ADDRESS,MOBILE_NUMBER,EMAIL,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS,PAN_NUMBER,SALARY)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		long accNumber = 0;
		Statement st = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(que);
			if (rs.next()) {
				accNumber = rs.getLong(1);
			}

			pstmt = con.prepareStatement(query);

			pstmt.setLong(1, accNumber);
			pstmt.setString(2, loan.getUsername());
			pstmt.setDate(3, java.sql.Date.valueOf(loan.getDob()));
			pstmt.setString(4, loan.getAddress());
			pstmt.setLong(5, loan.getMobno());
			pstmt.setString(6, loan.getEmail());
			pstmt.setString(7, loan.getLoanType());
			pstmt.setString(8, loan.getDescription());
			pstmt.setDouble(9, loan.getLoanAmount());
			pstmt.setDouble(10, loan.getTenure());
			pstmt.setDouble(11, loan.getInterestRate());
			pstmt.setDouble(12, loan.getMonthlyPayment());
			pstmt.setString(13, loan.getLoanStatus());
			pstmt.setString(14, loan.getPanNumber());
			pstmt.setDouble(15, loan.getSalary());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return accNumber;

	}

	@Override
	public long getAccNum(String email) throws SQLException {
		String query = "select Account_number from account_details where email= ?";
		long accNum = 0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(query);
			st.setString(1, email);
			rs = st.executeQuery();
			if (rs.next()) {
				accNum = rs.getLong(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return accNum;

	}

	@Override
	public boolean validateLoan(String pan) throws SQLException {
		String que = "select  * from loans where  pan_number= ? ";
		String query = "select  * from loans where  pan_number=? and Loan_status='Rejected' or Loan_status='NotApproved' ";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ResultSet rSet = null;
		boolean flag = true;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(que);
			st.setString(1, pan);
			rs = st.executeQuery();
			st = con.prepareStatement(query);
			st.setString(1, pan);
			if (rs.next()) {

				rSet = st.executeQuery(query);
				if (rSet.next()) {
					flag = false;

				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rSet != null)
				rSet.close();
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return flag;
	}

	public boolean validatePersonalLoan(String pan) throws SQLException {
		String que = "select  * from loans where  pan_number=? and Loan_type='Personal Loan' ";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(que);
			st.setString(1, pan);
			rs = st.executeQuery();
			if (rs.next()) {

				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	public boolean validateHouseLoan(String pan) throws SQLException {
		String que = "select  * from loans where  pan_number= ? and Loan_type='Housing Loan'";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(que);
			st.setString(1, pan);
			rs = st.executeQuery();
			if (rs.next()) {

				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return flag;
	}

	@Override
	public long housingLoan(Loans loan) throws SQLException {
		String que = "select  loan_acc.nextval from dual";
		String query = "INSERT INTO LOANS (ACCOUNT_NUMBER,ACC_HOLDER_NAME,DOB,ADDRESS,MOBILE_NUMBER,EMAIL,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS,PAN_NUMBER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		long accNumber = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(que);
			if (rs.next()) {
				accNumber = rs.getLong(1);
			}
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, accNumber);
			pstmt.setString(2, loan.getUsername());
			pstmt.setDate(3, java.sql.Date.valueOf(loan.getDob()));
			pstmt.setString(4, loan.getAddress());
			pstmt.setLong(5, loan.getMobno());
			pstmt.setString(6, loan.getEmail());
			pstmt.setString(7, loan.getLoanType());
			pstmt.setString(8, loan.getDescription());
			pstmt.setDouble(9, loan.getLoanAmount());
			pstmt.setDouble(10, loan.getTenure());
			pstmt.setDouble(11, loan.getInterestRate());
			pstmt.setDouble(12, loan.getMonthlyPayment());
			pstmt.setString(13, loan.getLoanStatus());
			pstmt.setString(14, loan.getPanNumber());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return accNumber;
	}

	@Override
	public List<Loans> viewloan() throws SQLException {
		List<Loans> loans = new ArrayList<>();
		String selectQuery = "select * from LOANS  ";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(selectQuery);
			while (rs.next()) {
				Loans loan = new Loans(rs.getLong(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getString(11), rs.getString(12), rs.getDouble(13),
						rs.getInt(14), rs.getDouble(15), rs.getDouble(16), rs.getString(17), rs.getString(18),
						rs.getDouble(19));
				loans.add(loan);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return loans;
	}

	@Override
	public boolean updateStatus(long accnum, String status) throws SQLException {
		String que = "UPDATE LOANS SET LOAN_STATUS= ? WHERE  Account_number=?";
		Connection con = null;
		PreparedStatement pst = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(que);
			pst.setString(1, status);
			pst.setLong(2, accnum);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}

		return flag;
	}

	@Override
	public List<Loans> viewStatusUser(long accNo) throws SQLException {
		List<Loans> list = new ArrayList<>();
		String query = "select  * from loans where account_number= ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNo);
			rs = pst.executeQuery(query);

			while (rs.next()) {
				Loans dep = new Loans(rs.getLong(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getString(11), rs.getString(12), rs.getDouble(13),
						rs.getInt(14), rs.getDouble(15), rs.getDouble(16), rs.getString(17), rs.getString(18));
				list.add(dep);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return list;

	}

	public boolean viewOneLoan(long accnum) throws SQLException {
		List<Loans> loans = new ArrayList<>();
		String query = "select * from Loans  where account_number= ? ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accnum);
			rs = pst.executeQuery();
			if (rs.next()) {
				Loans loan = new Loans(rs.getLong(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getString(11), rs.getString(12), rs.getDouble(13),
						rs.getInt(14), rs.getDouble(15), rs.getDouble(16), rs.getString(17), rs.getString(18));
				loans.add(loan);
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}

		return flag;
	}

	public double checkAmount(long accNum) throws SQLException {
		String query = "select  monthly_Payment from loans where  account_number=? ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		double monthlyPayment = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNum);
			rs = pst.executeQuery();
			if (rs.next()) {
				monthlyPayment = rs.getDouble("monthly_payment");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
		return monthlyPayment;
	}
}

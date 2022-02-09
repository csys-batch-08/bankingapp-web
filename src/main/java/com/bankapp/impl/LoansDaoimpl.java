package com.bankapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.dao.LoansDao;
import com.bankapp.logger.Logger;
import com.bankapp.model.Loans;
import com.bankapp.util.ConnectionUtil;

public class LoansDaoimpl implements LoansDao {
	private static final String APPROVED_DATE = "approved_date";
	private static final String SALARY = "salary";
	private static final String PAN_NUMBER = "pan_number";
	private static final String INTEREST_RATE = "interest_rate";
	private static final String LOAN_STATUS = "loan_status";
	private static final String MONTHLY_PAYMENT = "monthly_payment";
	private static final String TENURE = "tenure";
	private static final String LOAN_AMOUNT = "loan_amount";
	private static final String DESCRIPTION = "description";
	private static final String LOAN_TYPE = "loan_type";
	private static final String APPLIED_DATE = "applied_date";
	private static final String IFSC_CODE = "ifsc_code";
	private static final String EMAIL = "email";
	private static final String ACC_STATUS = "acc_status";
	private static final String MOBILE_NUMBER = "mobile_number";
	private static final String ADDRESS = "address";
	private static final String ACC_HOLDER_NAME = "acc_holder_name";
	private static final String ACCOUNT_NUMBER = "account_number";

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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pstmt, con);
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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatePrepareStatement(st, rs, pstmt, con);
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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, st, con);
		}
		return accNum;
	}

	@Override
	public boolean validateLoan(String pan) {
		String que = "select   account_number from loans where  pan_number= ? ";
		String query = "select  account_number from loans where  pan_number=? and Loan_status='Rejected' or Loan_status='NotApproved' ";
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		ResultSet rSet = null;
		boolean flag = true;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.prepareStatement(que);
			st.setString(1, pan);
			rs = st.executeQuery();
			state = con.prepareStatement(query);
			state.setString(1, pan);
			if (rs.next()) {
				rSet = state.executeQuery(query);
				if (rSet.next()) {
					flag = false;
				}
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}
			}
		}
		return flag;
	}

	public boolean validatePersonalLoan(String pan) throws SQLException {
		String que = "select   account_number from loans where  pan_number=? and Loan_type='Personal Loan' ";
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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, st, con);
		}
		return flag;
	}

	public boolean validateHouseLoan(String pan) throws SQLException {
		String que = "select  account_number from loans where  pan_number= ? and Loan_type='Housing Loan'";
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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, st, con);
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
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatePrepareStatement(st, rs, pstmt, con);
		}
		return accNumber;
	}

	@Override
	public List<Loans> viewloan() throws SQLException {
		List<Loans> loans = new ArrayList<>();
		String selectQuery = "select account_number,acc_holder_name,dob,address,mobile_number,email,ifsc_code,acc_status,applied_date,loan_type,description,loan_amount,tenure,interest_rate,monthly_payment,loan_status,pan_number,salary,Approved_date from LOANS  ";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			st = con.createStatement();
			rs = st.executeQuery(selectQuery);
			while (rs.next()) {
				Loans loan = new Loans(rs.getLong(ACCOUNT_NUMBER), rs.getString(ACC_HOLDER_NAME),
						rs.getDate("dob").toLocalDate(), rs.getString(ADDRESS), rs.getLong(MOBILE_NUMBER),
						rs.getString(EMAIL), rs.getString(IFSC_CODE), rs.getString(ACC_STATUS),
						rs.getDate(APPLIED_DATE).toLocalDate(), rs.getString(LOAN_TYPE), rs.getString(DESCRIPTION),
						rs.getDouble(LOAN_AMOUNT), rs.getInt(TENURE), rs.getDouble(INTEREST_RATE),
						rs.getDouble(MONTHLY_PAYMENT), rs.getString(LOAN_STATUS), rs.getString(PAN_NUMBER),
						rs.getDouble(SALARY), rs.getDate(APPROVED_DATE).toLocalDate());
				loans.add(loan);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(rs, st, con);
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
		String query = "select  account_number,acc_holder_name,dob,address,mobile_number,email,ifsc_code,acc_status,applied_date,loan_type,description,loan_amount,tenure,interest_rate,monthly_payment,loan_status,pan_number,salary,Approved_date from loans where account_number= ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, accNo);
			rs = pst.executeQuery();
			while (rs.next()) {
				Loans dep = new Loans(rs.getLong(ACCOUNT_NUMBER), rs.getString(ACC_HOLDER_NAME),
						rs.getDate("dob").toLocalDate(), rs.getString(ADDRESS), rs.getLong(MOBILE_NUMBER),
						rs.getString(EMAIL), rs.getString(IFSC_CODE), rs.getString(ACC_STATUS),
						rs.getDate(APPLIED_DATE).toLocalDate(), rs.getString(LOAN_TYPE), rs.getString(DESCRIPTION),
						rs.getDouble(LOAN_AMOUNT), rs.getInt(TENURE), rs.getDouble(INTEREST_RATE),
						rs.getDouble(MONTHLY_PAYMENT), rs.getString(LOAN_STATUS), rs.getString(PAN_NUMBER),
						rs.getDouble(SALARY), rs.getDate(APPROVED_DATE).toLocalDate());
				list.add(dep);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return list;

	}

	public boolean viewOneLoan(long accnum) throws SQLException {
		List<Loans> loans = new ArrayList<>();
		String query = "select account_number,acc_holder_name,dob,address,mobile_number,email,ifsc_code,acc_status,applied_date,loan_type,description,loan_amount,tenure,interest_rate,monthly_payment,loan_status,pan_number,salary,Approved_date from Loans  where account_number= ? ";
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
				Loans loan = new Loans(rs.getLong(ACCOUNT_NUMBER), rs.getString(ACC_HOLDER_NAME),
						rs.getDate("dob").toLocalDate(), rs.getString(ADDRESS), rs.getLong(MOBILE_NUMBER),
						rs.getString(EMAIL), rs.getString(IFSC_CODE), rs.getString(ACC_STATUS),
						rs.getDate(APPLIED_DATE).toLocalDate(), rs.getString(LOAN_TYPE), rs.getString(DESCRIPTION),
						rs.getDouble(LOAN_AMOUNT), rs.getInt(TENURE), rs.getDouble(INTEREST_RATE),
						rs.getDouble(MONTHLY_PAYMENT), rs.getString(LOAN_STATUS), rs.getString(PAN_NUMBER),
						rs.getDouble(SALARY), rs.getDate(APPROVED_DATE).toLocalDate());
				loans.add(loan);
				flag = true;
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
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
				monthlyPayment = rs.getDouble(MONTHLY_PAYMENT);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);
		}
		return monthlyPayment;
	}
}

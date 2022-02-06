package com.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.Loans;

public interface LoansDao {

	public double getInterest(double descriptionId) throws SQLException;

	public long getAccNum(String email) throws SQLException;

	public boolean validateLoan(String pan) throws SQLException;

	public long PersonalLoan(Loans loan) throws SQLException;

	public long housingLoan(Loans loan) throws SQLException;

	public List<Loans> viewloan() throws SQLException;

	public boolean updateStatus(long accnum, String status) throws SQLException;

	public List<Loans> viewStatusUser(long accNo) throws SQLException;

}

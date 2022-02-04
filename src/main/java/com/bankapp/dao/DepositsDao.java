package com.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.Deposits;

public interface DepositsDao {
	public double getInterest(double descriptionId) throws SQLException;

	public long fixedDeposit(String type, double amount, double rateOfInterest, double maturityValue, int period,
			String status, String pan, String email) throws SQLException;

	public long recurringDeposit(String type, double amount, double rateOfInterest, int period, double maturityValue,
			String status, String pan, String email, double totalAmount) throws SQLException;

	public List<Deposits> viewdeposit() throws SQLException;

	public boolean updateStatus(long accnum, String status);

	public List<Deposits> viewStatusUser(long accNo);

}

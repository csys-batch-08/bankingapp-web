package com.bankapp.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.bankapp.model.Transaction;

public interface TransactionDao {
	public boolean depositAmount(long senderAccNum, String uname, double amount, int pinNo, long receiverAccNO)
			throws SQLException;

	public double viewBalance(long accountNumber, int pinNo) throws SQLException;

	public int getPinnumber(long accountno) throws SQLException;

	public List<Transaction> getbyDate(LocalDate date) throws SQLException;

	public List<Transaction> getByAccountNumberUser(long accNo, int pin) throws SQLException;

	public List<Transaction> getByAccountNumberAdmin(long accNo) throws SQLException;

}

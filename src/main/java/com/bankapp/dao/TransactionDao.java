package com.bankapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.bankapp.model.Transaction;

public interface TransactionDao {
	public boolean depositAmount(long sender_AccNO, String Name, double amount, int pin_No, long receiver_AccNO);
	public boolean withdrawAmount(String name,long accountNo, double w_amount, int pinNo);
	public double viewBalance(long account_number, int pinNo);
	public  int  getPinnumber(  long accountno);
	public List<Transaction> getbyDate( LocalDate date);
	public List<Transaction> getByAccountNumberUser(long accNo,int pin) ;
	public List<Transaction> getByAccountNumberAdmin(long accNo );

}

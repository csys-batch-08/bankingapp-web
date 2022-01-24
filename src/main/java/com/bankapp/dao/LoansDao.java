package com.bankapp.dao;

import java.util.List;

import com.bankapp.model.Loans;

public interface LoansDao {

	public double getInterest(double descriptionId);

	public long getAccNum(String email);

	public boolean validateLoan(String pan);

	public long PersonalLoan(Loans loan);

	public long housingLoan(Loans loan);

	public List<Loans> viewloan();

	public boolean updateStatus(long accnum, String status);

	public List<Loans> viewStatusUser(long accNo);

}

package com.bankapp.dao;

import java.sql.ResultSet;
import java.util.List;

import com.bankapp.model.AccountDetails;

public interface AccountDetailsDao {
	public  boolean insertAccount(AccountDetails account);
	public List<AccountDetails> searchDetail(long accNumber,int pinNumber);
	public  boolean updateUserDetailAdmin(String email,long mobilenumber,String email1);
	public boolean deleteDetails( long  accountnum ,String status);
	public String getUserId(String email);
}

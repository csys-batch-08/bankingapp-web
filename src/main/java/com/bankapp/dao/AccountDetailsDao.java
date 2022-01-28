package com.bankapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.AccountDetails;

public interface AccountDetailsDao {
	public  boolean insertAccount(AccountDetails account) throws SQLException;
	public List<AccountDetails> searchDetail(long accNumber,int pinNumber) throws SQLException;
	public List<AccountDetails> viewAccout() throws SQLException;
	public  boolean updateUserDetailAdmin(String email,long mobilenumber,String email1) throws SQLException;
	public boolean deleteDetails( long  accountnum ,String status) throws SQLException;
	public String getUserId(String email) throws SQLException;
}

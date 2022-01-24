package com.bankapp.dao;

import java.util.List;

import com.bankapp.model.UserDetails;

public interface UserDetailsDao {

	public int insertUser(UserDetails user);
	public UserDetails validateUser(String emailId, String password);
	public  boolean updateUser(String name,String password,String email);
	public UserDetails admin(String email_id, String password);
	public List<UserDetails> viewUser();
	public  boolean deleteDetails(String email) ;
}

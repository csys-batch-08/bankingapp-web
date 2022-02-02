package com.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.UserDetails;

public interface UserDetailsDao {

	public int insertUser(UserDetails user) throws SQLException;

	public UserDetails validateUser(String emailId, String password) throws SQLException;

	public boolean updateUser(String name, String password, String email) throws SQLException;

	public UserDetails admin(String emailId, String password) throws SQLException;

	public List<UserDetails> viewUser() throws SQLException;

	public boolean deleteDetails(String email) throws SQLException;
}

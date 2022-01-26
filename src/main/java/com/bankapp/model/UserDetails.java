package com.bankapp.model;

import java.util.Objects;

public class UserDetails {
	private int userId;	
	private String username;
	private String emailId;
	private String userpassword;
	private long mobileNumber;

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getuserpassword() {
		return userpassword;
	}

	public void setuserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public long getmobileNumber() {
		return mobileNumber;
	}

	public void setmobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
     
	public UserDetails(int userId, String username, String emailId, String userpassword, long mobileNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.emailId = emailId;
		this.userpassword = userpassword;
		this.mobileNumber = mobileNumber;
	}
	public UserDetails( String username, String emailId, String userpassword, long mobileNumber) {
		super();
		 
		this.username = username;
		this.emailId = emailId;
		this.userpassword = userpassword;
		this.mobileNumber = mobileNumber;
	}

	public UserDetails() {
		super();
	 
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(emailId, mobileNumber, userId, username, userpassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(emailId, other.emailId) && mobileNumber == other.mobileNumber
				&& userId == other.userId && Objects.equals(username, other.username)
				&& Objects.equals(userpassword, other.userpassword);
	}

	@Override
	public String toString() {
		return " Name:" + username +"\t "+" EmailId:" + emailId
				+ "\t "+  "MobileNumber:" + mobileNumber;
	}

	 
	
}
package com.bankapp.model;

import java.util.Objects;

public class ContactUs {

	 private String userName;
	 private String email;
	 private String message;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ContactUs(String userName, String email, String message) {
		super();
		this.userName = userName;
		this.email = email;
		this.message = message;
	}
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, message, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactUs other = (ContactUs) obj;
		return Objects.equals(email, other.email) && Objects.equals(message, other.message)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "ContactUs [userName=" + userName + ", email=" + email + ", message=" + message + "]";
	}
	 
	 
}

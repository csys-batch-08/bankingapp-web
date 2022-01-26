package com.bankapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class AccountDetails {
	private int  userId;
	private  Long accountNumber;
	private String accountType;
	private String accountHolderName;
	private String address;
	private String city;
	private int pincode;
	private  LocalDate dob;
	private long mobileNumber;
	private String email;
	private String ifscCode;
	private String branchName;
	private double balance;	
	private int pinNumber;
	private String status;
	private String pan;
	 
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public  long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber( long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public AccountDetails(int userId,  long accountNumber, String accountType, String accountHolderName,
			String address, String city, int pincode, LocalDate dob, long mobileNumber, String email, String ifscCode,
			String branchName, double balance, int pinNumber, String status,String pan) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.ifscCode = ifscCode;
		this.branchName = branchName;
		this.balance = balance;
		this.pinNumber = pinNumber;
		this.status = status;
		this.pan=pan;
	}
	 
	public AccountDetails() {
		super();
	 
	}
	 
	 
	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, accountNumber, accountType, address, balance, branchName, city, dob,
				email, ifscCode, mobileNumber, pinNumber, pincode, status, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetails other = (AccountDetails) obj;
		return Objects.equals(accountHolderName, other.accountHolderName)
				&& Objects.equals(accountNumber, other.accountNumber)
				&& Objects.equals(accountType, other.accountType) && Objects.equals(address, other.address)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(branchName, other.branchName) && Objects.equals(city, other.city)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(ifscCode, other.ifscCode) && mobileNumber == other.mobileNumber
				&& pinNumber == other.pinNumber && pincode == other.pincode && Objects.equals(status, other.status)
				&& userId == other.userId;
	}
	@Override
	public String toString() {
		return "AccountDetails [user_id=" + userId + ", account_number=" + accountNumber + ", account_type="
				+ accountType + ", account_Holder_name=" + accountHolderName + ", address=" + address + ", city="
				+ city + ", pincode=" + pincode + ", dob=" + dob + ", mobile_Number=" + mobileNumber + ", email="
				+ email + ", ifsc_Code=" + ifscCode + ", branchName=" + branchName + ", balance=" + balance
				+ ", pin_Number=" + pinNumber + ", status=" + status + "]";
	}
	 
	 
	 


}

package com.bankapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class AccountDetails {
	private int  user_id;
	private  Long account_number;
	private String account_type;
	private String account_Holder_name;
	private String address;
	private String city;
	private int pincode;
	private  LocalDate dob;
	private long mobile_Number;
	private String email;
	private String ifsc_Code;
	private String branchName;
	private double balance;	
	private int pin_Number;
	private String status;
	private String pan;
	 
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public  long getAccount_number() {
		return account_number;
	}
	public void setAccount_number( long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_Holder_name() {
		return account_Holder_name;
	}
	public void setAccount_Holder_name(String account_Holder_name) {
		this.account_Holder_name = account_Holder_name;
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
	public long getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIfsc_Code() {
		return ifsc_Code;
	}
	public void setIfsc_Code(String ifsc_Code) {
		this.ifsc_Code = ifsc_Code;
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
	public int getPin_Number() {
		return pin_Number;
	}
	public void setPin_Number(int pin_Number) {
		this.pin_Number = pin_Number;
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
	public AccountDetails(int user_id,  long account_number, String account_type, String account_Holder_name,
			String address, String city, int pincode, LocalDate dob, long mobile_Number, String email, String ifsc_Code,
			String branchName, double balance, int pin_Number, String status,String pan) {
		super();
		this.user_id = user_id;
		this.account_number = account_number;
		this.account_type = account_type;
		this.account_Holder_name = account_Holder_name;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.dob = dob;
		this.mobile_Number = mobile_Number;
		this.email = email;
		this.ifsc_Code = ifsc_Code;
		this.branchName = branchName;
		this.balance = balance;
		this.pin_Number = pin_Number;
		this.status = status;
		this.pan=pan;
	}
	 
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	@Override
	public int hashCode() {
		return Objects.hash(account_Holder_name, account_number, account_type, address, balance, branchName, city, dob,
				email, ifsc_Code, mobile_Number, pin_Number, pincode, status, user_id);
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
		return Objects.equals(account_Holder_name, other.account_Holder_name)
				&& Objects.equals(account_number, other.account_number)
				&& Objects.equals(account_type, other.account_type) && Objects.equals(address, other.address)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(branchName, other.branchName) && Objects.equals(city, other.city)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(ifsc_Code, other.ifsc_Code) && mobile_Number == other.mobile_Number
				&& pin_Number == other.pin_Number && pincode == other.pincode && Objects.equals(status, other.status)
				&& user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "AccountDetails [user_id=" + user_id + ", account_number=" + account_number + ", account_type="
				+ account_type + ", account_Holder_name=" + account_Holder_name + ", address=" + address + ", city="
				+ city + ", pincode=" + pincode + ", dob=" + dob + ", mobile_Number=" + mobile_Number + ", email="
				+ email + ", ifsc_Code=" + ifsc_Code + ", branchName=" + branchName + ", balance=" + balance
				+ ", pin_Number=" + pin_Number + ", status=" + status + "]";
	}
	 
	 
	 


}

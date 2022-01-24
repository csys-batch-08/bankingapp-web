package com.bankapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Loans {
	 
	private long account_number;
    private String user_name;
    private  LocalDate dob;
    private String address;
    private String email;
    private long mobno;
	private String loan_type;
	private String description;
	private double Loan_amount;
	private int tenure;
	private double interest_rate;
	private double monthly_payment;
	private String loan_status;
	private  String  panNumber;
 
	

	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public  LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLoan_amount() {
		return Loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		Loan_amount = loan_amount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public double getMonthly_payment() {
		return monthly_payment;
	}
	public void setMonthly_payment(double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}
	public String getLoan_status() {
		return loan_status;
	}
	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Loans(  long account_number, String loan_type, String description, double loan_amount,
			       int tenure, double interest_rate, double monthly_payment, String loan_status) {
		super();
		
		this.account_number = account_number;
		this.loan_type = loan_type;
		this.description = description;
		this.Loan_amount = loan_amount;
		this.tenure = tenure;
		this.interest_rate = interest_rate;
		this.monthly_payment = monthly_payment;
		this.loan_status = loan_status;
	}
	public Loans(  long account_number, String user_name, LocalDate dob, String address,long mobno, String email,
			 String loan_type, String description, double loan_amount, int tenure, double interest_rate,
			double monthly_payment, String loan_status, String panNumber) {
		super();
		 
		this.account_number = account_number;
		this.user_name = user_name;
		this.dob = dob;
		this.address = address;
		
		this.mobno = mobno;
		this.email = email;
		this.loan_type = loan_type;
		this.description = description;
		this.Loan_amount = loan_amount;
		this.tenure = tenure;
		this.interest_rate = interest_rate;
		this.monthly_payment = monthly_payment;
		this.loan_status = loan_status;
		this.panNumber = panNumber;
	}
	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loans(long account_number, double monthly_payment, String loan_status) {
		// TODO Auto-generated constructor stub
		this.account_number = account_number;
		this.monthly_payment = monthly_payment;
		this.loan_status = loan_status;
	}
	@Override
	public String toString() {
		return "Loans [  account_number=" + account_number + ", user_name=" + user_name
				+ ", dob=" + dob + ", address=" + address + ", email=" + email + ", mobno=" + mobno + ", loan_type="
				+ loan_type + ", description=" + description + ", Loan_amount=" + Loan_amount + ", tenure=" + tenure
				+ ", interest_rate=" + interest_rate + ", monthly_payment=" + monthly_payment + ", loan_status="
				+ loan_status + ", panNumber=" + panNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Loan_amount, account_number, address, description, dob, email, interest_rate, loan_status,
				loan_type, mobno, monthly_payment, panNumber, tenure, user_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loans other = (Loans) obj;
		return Double.doubleToLongBits(Loan_amount) == Double.doubleToLongBits(other.Loan_amount)
				&& account_number == other.account_number && Objects.equals(address, other.address)
				&& Objects.equals(description, other.description) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email)
				&& Double.doubleToLongBits(interest_rate) == Double.doubleToLongBits(other.interest_rate)
				&& Objects.equals(loan_status, other.loan_status) && Objects.equals(loan_type, other.loan_type)
				&& mobno == other.mobno
				&& Double.doubleToLongBits(monthly_payment) == Double.doubleToLongBits(other.monthly_payment)
				&& Objects.equals(panNumber, other.panNumber) && Objects.equals(tenure, other.tenure)
				  && Objects.equals(user_name, other.user_name);
	}
	 

}

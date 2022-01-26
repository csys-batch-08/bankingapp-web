package com.bankapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Loans {
	 
	private long accountNumber;
    private String username;
    private  LocalDate dob;
    private String address;
    private String email;
    private long mobno;
	private String loanType;
	private String description;
	private double loanAmount;
	private int tenure;
	private double interestRate;
	private double monthlyPayment;
	private String loanStatus;
	private  String  panNumber;
 
	

	 
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getDob() {
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
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Loans(  long accountNumber, String loanType, String description, double loanAmount,
			       int tenure, double interestRate, double monthlyPayment, String loanStatus) {
		super();
		
		this.accountNumber = accountNumber;
		this.loanType = loanType;
		this.description = description;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.interestRate = interestRate;
		this.monthlyPayment = monthlyPayment;
		this.loanStatus = loanStatus;
	}
	public Loans(  long accountNumber, String username, LocalDate dob, String address,long mobno, String email,
			 String loanType, String description, double loanAmount, int tenure, double interestRate,
			double monthlyPayment, String loanStatus, String panNumber) {
		super();
		 
		this.accountNumber = accountNumber;
		this.username = username;
		this.dob = dob;
		this.address = address;
		this.mobno = mobno;
		this.email = email;
		this.loanType = loanType;
		this.description = description;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.interestRate = interestRate;
		this.monthlyPayment = monthlyPayment;
		this.loanStatus = loanStatus;
		this.panNumber = panNumber;
	}
	public Loans() {
		super();
 
	}
	public Loans(long accountNumber, double monthlyPayment, String loanStatus) {
		 
		this.accountNumber = accountNumber;
		this.monthlyPayment = monthlyPayment;
		this.loanStatus = loanStatus;
	}
	@Override
	public String toString() {
		return "Loans [  account_number=" + accountNumber + ", user_name=" + username
				+ ", dob=" + dob + ", address=" + address + ", email=" + email + ", mobno=" + mobno + ", loan_type="
				+ loanType + ", description=" + description + ", Loan_amount=" + loanAmount + ", tenure=" + tenure
				+ ", interest_rate=" + interestRate + ", monthly_payment=" + monthlyPayment + ", loan_status="
				+ loanStatus + ", panNumber=" + panNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(loanAmount, accountNumber, address, description, dob, email, interestRate, loanStatus,
				loanType, mobno, monthlyPayment, panNumber, tenure, username);
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
		return Double.doubleToLongBits(loanAmount) == Double.doubleToLongBits(other.loanAmount)
				&& accountNumber == other.accountNumber && Objects.equals(address, other.address)
				&& Objects.equals(description, other.description) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email)
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate)
				&& Objects.equals(loanStatus, other.loanStatus) && Objects.equals(loanType, other.loanType)
				&& mobno == other.mobno
				&& Double.doubleToLongBits(monthlyPayment) == Double.doubleToLongBits(other.monthlyPayment)
				&& Objects.equals(panNumber, other.panNumber) && Objects.equals(tenure, other.tenure)
				  && Objects.equals(username, other.username);
	}
	 

}

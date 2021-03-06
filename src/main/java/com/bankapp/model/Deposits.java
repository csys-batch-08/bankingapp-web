package com.bankapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Deposits implements Serializable {

	private static final long serialVersionUID = 1L;

	private long depositNumber;
	private long accno;
	private int userId;
	private String depositType;
	private double amount;
	private LocalDate dateOfDeposit;
	private int tenure;
	private double rateOfInterest;
	private LocalDate maturityDate;
	private double maturityValue;
	private String depositStatus;
	private String pan;

	private LocalDate approvedDate;
	private Double totalAmount;

	public Deposits(long depositNumber, long accno, int userId, String depositType, double amount,
			LocalDate dateOfDeposit, int tenure, double rateOfInterest, LocalDate maturityDate, double maturityValue,
			String depositStatus, String pan, LocalDate approvedDate, double totalAmount) {
		super();
		this.depositNumber = depositNumber;
		this.accno = accno;
		this.userId = userId;
		this.depositType = depositType;
		this.amount = amount;
		this.dateOfDeposit = dateOfDeposit;
		this.tenure = tenure;
		this.rateOfInterest = rateOfInterest;
		this.maturityDate = maturityDate;
		this.maturityValue = maturityValue;
		this.depositStatus = depositStatus;
		this.pan = pan;
		this.approvedDate = approvedDate;
		this.totalAmount = totalAmount;
	}

	public long getDepositNumber() {
		return depositNumber;
	}

	public void setDepositNumber(long depositNumber) {
		this.depositNumber = depositNumber;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfDeposit() {
		return dateOfDeposit;
	}

	public void setDateOfDeposit(LocalDate dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getMaturityValue() {
		return maturityValue;
	}

	public void setMaturityValue(double maturityValue) {
		this.maturityValue = maturityValue;
	}

	public String getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Deposits() {
		super();

	}

	@Override
	public int hashCode() {
		return Objects.hash(accno, amount, approvedDate, dateOfDeposit, depositNumber, depositStatus, depositType,
				maturityDate, maturityValue, pan, rateOfInterest, tenure, totalAmount, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposits other = (Deposits) obj;
		return accno == other.accno && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(approvedDate, other.approvedDate)
				&& Objects.equals(dateOfDeposit, other.dateOfDeposit) && depositNumber == other.depositNumber
				&& Objects.equals(depositStatus, other.depositStatus) && Objects.equals(depositType, other.depositType)
				&& Objects.equals(maturityDate, other.maturityDate)
				&& Double.doubleToLongBits(maturityValue) == Double.doubleToLongBits(other.maturityValue)
				&& Objects.equals(pan, other.pan)
				&& Double.doubleToLongBits(rateOfInterest) == Double.doubleToLongBits(other.rateOfInterest)
				&& tenure == other.tenure && Objects.equals(totalAmount, other.totalAmount) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "Deposits [depositNumber=" + depositNumber + ", accno=" + accno + ", userId=" + userId + ", depositType="
				+ depositType + ", amount=" + amount + ", dateOfDeposit=" + dateOfDeposit + ", tenure=" + tenure
				+ ", rateOfInterest=" + rateOfInterest + ", maturityDate=" + maturityDate + ", maturityValue="
				+ maturityValue + ", depositStatus=" + depositStatus + ", pan=" + pan + ", approvedDate=" + approvedDate
				+ ", totalAmount=" + totalAmount + "]";
	}

}

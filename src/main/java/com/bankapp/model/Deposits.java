package com.bankapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Deposits {
	    private long depositNumber;
        private long accno;
        private int user_id;
     	private String deposit_type;
        private double amount;
        private LocalDate date_of_deposit;
        private  int tenure;
        private double rate_of_interest;
        private  LocalDate maturity_date;
        private double maturity_value;
        private String deposit_status;
        private String pan;
		private LocalDate approved_date;
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
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getDeposit_type() {
			return deposit_type;
		}
		public void setDeposit_type(String deposit_type) {
			this.deposit_type = deposit_type;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public LocalDate getDate_of_deposit() {
			return date_of_deposit;
		}
		public void setDate_of_deposit(LocalDate date_of_deposit) {
			this.date_of_deposit = date_of_deposit;
		}
		public int getTenure() {
			return tenure;
		}
		public void setTenure(int tenure) {
			this.tenure = tenure;
		}
		public double getRate_of_interest() {
			return rate_of_interest;
		}
		public void setRate_of_interest(double rate_of_interest) {
			this.rate_of_interest = rate_of_interest;
		}
		public LocalDate getMaturity_date() {
			return maturity_date;
		}
		public void setMaturity_date(LocalDate maturity_date) {
			this.maturity_date = maturity_date;
		}
		public double getMaturity_value() {
			return maturity_value;
		}
		public void setMaturity_value(double maturity_value) {
			this.maturity_value = maturity_value;
		}
		public String getDeposit_status() {
			return deposit_status;
		}
		public void setDeposit_status(String deposit_status) {
			this.deposit_status = deposit_status;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public LocalDate getApproved_date() {
			return approved_date;
		}
		public void setApproved_date(LocalDate approved_date) {
			this.approved_date = approved_date;
		}
		public Deposits(long depositNumber, long accno, int user_id, String deposit_type, double amount,
				LocalDate date_of_deposit, int tenure, double rate_of_interest, LocalDate maturity_date,
				double maturity_value, String deposit_status, String pan, LocalDate approved_date) {
			super();
			this.depositNumber = depositNumber;
			this.accno = accno;
			this.user_id = user_id;
			this.deposit_type = deposit_type;
			this.amount = amount;
			this.date_of_deposit = date_of_deposit;
			this.tenure = tenure;
			this.rate_of_interest = rate_of_interest;
			this.maturity_date = maturity_date;
			this.maturity_value = maturity_value;
			this.deposit_status = deposit_status;
			this.pan = pan;
			this.approved_date = approved_date;
		}
		public Deposits() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			return Objects.hash(accno, amount, approved_date, date_of_deposit, depositNumber, deposit_status,
					deposit_type, maturity_date, maturity_value, pan, rate_of_interest, tenure, user_id);
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
					&& Objects.equals(approved_date, other.approved_date)
					&& Objects.equals(date_of_deposit, other.date_of_deposit) && depositNumber == other.depositNumber
					&& Objects.equals(deposit_status, other.deposit_status)
					&& Objects.equals(deposit_type, other.deposit_type)
					&& Objects.equals(maturity_date, other.maturity_date)
					&& Double.doubleToLongBits(maturity_value) == Double.doubleToLongBits(other.maturity_value)
					&& Objects.equals(pan, other.pan)
					&& Double.doubleToLongBits(rate_of_interest) == Double.doubleToLongBits(other.rate_of_interest)
					&& tenure == other.tenure && user_id == other.user_id;
		}
		@Override
		public String toString() {
			return "Deposits [depositNumber=" + depositNumber + ", accno=" + accno + ", user_id=" + user_id
					+ ", deposit_type=" + deposit_type + ", amount=" + amount + ", date_of_deposit=" + date_of_deposit
					+ ", tenure=" + tenure + ", rate_of_interest=" + rate_of_interest + ", maturity_date="
					+ maturity_date + ", maturity_value=" + maturity_value + ", deposit_status=" + deposit_status
					+ ", pan=" + pan + ", approved_date=" + approved_date + "]";
		}
		 
		 
		 


}

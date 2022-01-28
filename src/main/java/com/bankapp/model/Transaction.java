package com.bankapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Transaction {
	         private long senderAccountNumber;
	          private String name;
             private String transactionType;
             private long receiveAccountNumber;
             private double amount;
             private  double balance;
             private String transactionstatus;
			 private LocalDate transactiondate;
			public long getSenderAccountNumber() {
				return senderAccountNumber;
			}
			public void setSenderAccountNumber(long senderAccountNumber) {
				this.senderAccountNumber = senderAccountNumber;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getTransactionType() {
				return transactionType;
			}
			public void setTransactionType(String transactionType) {
				this.transactionType = transactionType;
			}
			public long getReceiveAccountNumber() {
				return receiveAccountNumber;
			}
			public void setReceiveAccountNumber(long receiveAccountNumber) {
				this.receiveAccountNumber = receiveAccountNumber;
			}
			public double getAmount() {
				return amount;
			}
			public void setAmount(double amount) {
				this.amount = amount;
			}
			public double getBalance() {
				return balance;
			}
			public void setBalance(double balance) {
				this.balance = balance;
			}
			public String getTransactionstatus() {
				return transactionstatus;
			}
			public void setTransactionstatus(String transactionstatus) {
				this.transactionstatus = transactionstatus;
			}
			public LocalDate getTransactiondate() {
				return transactiondate;
			}
			public void setTransactiondate(LocalDate transactiondate) {
				this.transactiondate = transactiondate;
			}
			public Transaction(long senderAccountNumber, String name, String transactionType, long receiveAccountNumber,
					double amount, double balance, String transactionstatus, LocalDate transactiondate) {
				super();
				this.senderAccountNumber = senderAccountNumber;
				this.name = name;
				this.transactionType = transactionType;
				this.receiveAccountNumber = receiveAccountNumber;
				this.amount = amount;
				this.balance = balance;
				this.transactionstatus = transactionstatus;
				this.transactiondate = transactiondate;
			}
			public Transaction() {
				super();
				// TODO Auto-generated constructor stub
			}
			@Override
			public int hashCode() {
				return Objects.hash(amount, balance, name, receiveAccountNumber, senderAccountNumber, transactionType,
						transactiondate, transactionstatus);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Transaction other = (Transaction) obj;
				return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
						&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
						&& Objects.equals(name, other.name) && receiveAccountNumber == other.receiveAccountNumber
						&& senderAccountNumber == other.senderAccountNumber
						&& Objects.equals(transactionType, other.transactionType)
						&& Objects.equals(transactiondate, other.transactiondate)
						&& Objects.equals(transactionstatus, other.transactionstatus);
			}
			@Override
			public String toString() {
				return "Transaction [senderAccountNumber=" + senderAccountNumber + ", name=" + name
						+ ", transactionType=" + transactionType + ", receiveAccountNumber=" + receiveAccountNumber
						+ ", amount=" + amount + ", balance=" + balance + ", transactionstatus=" + transactionstatus
						+ ", transactiondate=" + transactiondate + "]";
			}
			 
			 
			 
			 
			 
			 


}

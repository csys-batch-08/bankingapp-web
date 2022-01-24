package com.bankapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Transaction {
	         private long sender_Account_number;
	          private String name;
             private String transaction_type;
             private long receiver_account_number;
             private double amount;
             private  double balance;
             private String transaction_status;
			 private LocalDate transaction_date;
			public long getSender_Account_number() {
				return sender_Account_number;
			}
			public void setSender_Account_number(long sender_Account_number) {
				this.sender_Account_number = sender_Account_number;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getTransaction_type() {
				return transaction_type;
			}
			public void setTransaction_type(String transaction_type) {
				this.transaction_type = transaction_type;
			}
			public long getReceiver_account_number() {
				return receiver_account_number;
			}
			public void setReceiver_account_number(long receiver_account_number) {
				this.receiver_account_number = receiver_account_number;
			}
			public  double getAmount() {
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
			public String getTransaction_status() {
				return transaction_status;
			}
			public void setTransaction_status(String transaction_status) {
				this.transaction_status = transaction_status;
			}
			public LocalDate getTransaction_date() {
				return transaction_date;
			}
			public void setTransaction_date(LocalDate transaction_date) {
				this.transaction_date = transaction_date;
			}
			public Transaction(long sender_Account_number, String name, String transaction_type,
					long receiver_account_number, double amount, double balance, String transaction_status,
					LocalDate transaction_date) {
				super();
				this.sender_Account_number = sender_Account_number;
				this.name = name;
				this.transaction_type = transaction_type;
				this.receiver_account_number = receiver_account_number;
				this.amount = amount;
				this.balance = balance;
				this.transaction_status = transaction_status;
				this.transaction_date = transaction_date;
			}
			public Transaction(long lsender_Account_number, String name, String transaction_type, long receiver_account_number, double amount, LocalDate transaction_date) {
				super();
				this.sender_Account_number = sender_Account_number;
				this.name = name;
				this.transaction_type = transaction_type;
				this.receiver_account_number = receiver_account_number;
				this.amount = amount;
				this.transaction_date = transaction_date;
				// TODO Auto-generated constructor stub
			}
			 
			public Transaction(long sender_Account_number, String name, String transaction_type, long receiver_account_number, double amount) {
				this.sender_Account_number = sender_Account_number;
				this.name = name;
				this.transaction_type = transaction_type;
				this.receiver_account_number = receiver_account_number;
				this.amount = amount;
				this.sender_Account_number = sender_Account_number;
				this.name = name;
				this.transaction_type = transaction_type;
				this.receiver_account_number = receiver_account_number;
				this.amount = amount;
				// TODO Auto-generated constructor stub
			}
			public Transaction(long sender_Account_number, String name, String transaction_type, long receiver_account_number, double amount, String transaction_status,
					LocalDate transaction_date) {
				// TODO Auto-generated constructor stub
				this.sender_Account_number = sender_Account_number;
				this.name = name;
				this.transaction_type = transaction_type;
				this.receiver_account_number = receiver_account_number;
				this.amount = amount;
				this.transaction_date = transaction_date;
			}
			@Override
			public int hashCode() {
				return Objects.hash(amount, balance, name, receiver_account_number, sender_Account_number,
						transaction_date, transaction_status, transaction_type);
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
				return amount == other.amount && balance == other.balance && Objects.equals(name, other.name)
						&& receiver_account_number == other.receiver_account_number
						&& sender_Account_number == other.sender_Account_number
						&& Objects.equals(transaction_date, other.transaction_date)
						&& Objects.equals(transaction_status, other.transaction_status)
						&& Objects.equals(transaction_type, other.transaction_type);
			}
			@Override
			public String toString() {
				return "Transaction [sender_Account_number=" + sender_Account_number + ", name=" + name
						+ ", transaction_type=" + transaction_type + ", receiver_account_number="
						+ receiver_account_number + ", amount=" + amount + ", balance=" + balance
						+ ", transaction_status=" + transaction_status + ", transaction_date=" + transaction_date + "]";
			}
			 
			 


}

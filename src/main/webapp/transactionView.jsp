<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>TransactionSummary</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 16px;
	color: black;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	width:100%;
	padding: 7px;
}

nav a {
	padding-right: 77.5px;
}

h1 {
	color: white;
	background: #042331;
	height: 10%;
	margin: 0;
	padding: 7px;
}

a {
	text-decoration: none;
	color: white;
}

.set1 {
	padding-right: 325.5px;
}

.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float:right;
}
 
.sidebar {
	position: absolute;
	left: 0;
	width: 250px;
	height: 1200px;
	background-color: rgba(9, 57, 87, .8);
	color: white;
}

.sidebar header {
	font-size: 15px;
	color: white;
	text-align: center;
	line-height: 50px;
	background-color: rgba(9, 57, 87, .3);
}

ul {
	list-style-type: none;
}

.sidebar ul a {
	height: 98%;
	width: 99%;
	line-height: 40px;
	font-size: 15px;
	padding-left: 40px;
	color: white;
}

ul li:hover a {
	padding-left: 50px;
}

.sidebar ul a {
	margin-right: 0px;
}

.box {
	width: 380px;
	height: 380px;
	position: relative;
	margin: 6% auto;
	background: transparent;
	padding: 5px;
	box: shadow;
}

 

.pa {
	text-align: left;
}

.par {
	padding: 20px;
}

.btn2 {
	padding: 5px 15px;
	color: white;
	background-color: green;
	margin-right: 30px;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 930px;
}

body {
	background-color: rgba(198, 208, 214, .9);
}

#transhead {
	color: green;
}

.t1 {
	padding: 10px;
	padding-left: 350px;
	border: none;
}

td {
	padding-left: 15px;
}

th {
	padding-left: 10px;
	font-size: 18px;
}

.table {
	margin-bottom: 10px;
	width: 1000px;
	margin-left: 180px;
}

.table th {
	background-color: rgba(161, 15, 95, .5);
}

.table td {
	background-color: rgba(35, 106, 240, .5);
}
</style>
</head>
<body>
	<img src="images/boilogo.png" alt="couldnot load" width="400"
		height="100" /><br>
	<nav>
		<a href="customerDashBoard.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		  <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="myProfile.jsp">My Profile</a>
		<button class="btn">
			<a href="LogoutServlet">Logout</a>
		</button>
	</nav>
	<br>
	<br>
 	<div class="sidebar">

		<header>My Account</header>
		<ul>
			<li><a href="accountDetail.jsp">AccountDetails</a></li>
			<li><a href="transferAmount.jsp">Transfer</a></li>
			<li><a href="balance.jsp">Balance</a></li>
			<li><a href="fixedDeposit.jsp">Fixed Deposits</a></li>
			<li><a href="recurringDeposit.jsp">Recurring Deposits</a></li>
			<li><a href="personalLoan.jsp">Personal Loan request</a></li>
			<li><a href="housingLoan.jsp">Housing Loan request</a></li>
			<li><a href="transactionSummary.jsp">Transaction History</a></li>
			<li><a href="depositStatusUser.jsp">Deposit Status</a></li>
			<li><a href="loanStatusUser.jsp">Loan Status</a></li>

		</ul>
	</div>

	<h2 align="center">Transaction Summary</h2>
	<div class="">


		<div class="container mt-4 mb-4">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>S.no</th>
						<th>Sender Account Number</th>
						<th>Name</th>
						<th>Transaction</th>
						<th>Receive Account Number</th>
						<th>Amount</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${TransacSummary}" var="Transacviewlist">
						<c:set var="i" value="${i+1 }" />
						<tr>


							<td>${i}</td>
							<td>${Transacviewlist.senderAccountNumber }</td>
							<td>${Transacviewlist.name}</td>
							<td>${Transacviewlist.transactionType}</td>
							<td>${Transacviewlist.receiveAccountNumber}</td>
							<td>${Transacviewlist.amount}</td>
							<td>${Transacviewlist.transactiondate }</td>
							

						</tr>
 </c:forEach>
					
				</tbody>
			</table>
		</div>
		<div class="btn3">
			<button type="submit" class="btn2">
				<a href="customerDashBoard.jsp">Back</a>
			</button>
		</div>
	</div>

</body>
</html>
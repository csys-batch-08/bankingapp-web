 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Status</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87,.9);
	 width:99.9%;
	padding: 6px;
}
nav a {
	padding-right: 94px;
	text-decoration:none;
	color:white;
}
nav a:hover{
text-decoration:none;
color:black;}
 a {
	text-decoration: none;
	color: white;
}
.set1 {
	padding-right: 311.5px;
}
.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float:right;
}
 .sidebar {
	position: fixed;
	left: 0;
	width: 250px;
	height: 100%;
	background-color: rgba(9, 57, 87,.8);
	color: white;
}
.sidebar header {
	font-size: 15px;
	color: white;
	text-align: center;
	line-height: 50px;
background-color: rgba(9, 57, 87,.3);
 text-transform: capitalize;
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
	margin: 4% auto;
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
.t1 {
	padding: 90px;
	padding-left: 350px;
	border:none;
}
 .btn2 {
	padding: 5px 15px;
	color: white;
	background-color:green;
	margin-right: 30px;
	border:0;
	border-radius:5px;
}
.btn2 a:hover{
text-decoration:none;
color:white;}
.btn3 {
	margin-left: 870px;
}
body {
	background-color: rgba(198, 208, 214,.9);
}
td {
	padding-left: 20px;
	text-align: justify;
	padding-bottom: 8px;
}
th {
	text-align: justify;
	padding-left: 30px;
	padding-bottom: 8px;
}
.table{
margin-bottom:10px;
 width:950px;
 margin-left:150px;
}
.table th{
background-color:  rgba(161, 15, 95,.5);}
.table td{
background-color:  rgba(35, 106, 240,.5);}
#head{
  font-family:  Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
  font-size:23px;
 }
</style>
</head>
<body>
	 <br> <h3 id="head"><i> Dharshini Bank</i></h3><br> 
	<nav>
		<a href="customerDashBoard.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		 <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" >ContactUs</a>
		  <a href="myProfile.jsp">My Profile</a>
		<button class="btn"><a href="LogoutServlet">Logout</a></button>
	</nav>
	<br>
	<br>
  	<div class="sidebar">
		<header>${sessionScope.username}</header>
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
	          <h2 align="center">Deposits</h2>
		<div class="container mt-4 mb-4">
      <table class="table table-hover table-striped">
        <caption> 
			<thead>
				<tr>
					<th>S.no</th>
					<th>Deposit Number</th>
					<th>Account Number</th>
					<th>Deposit Type</th>
					<th>Amount</th>
					<th>Maturity Date</th>
					<th>Rate Of Interest</th>
					<th>Tenure</th>
					<th>MaturityValue</th>
					<th>Status</th>

				</tr>
			</thead>
             <tbody>
				<c:forEach items="${Deposits}" var="depositView">
				  <c:set var="i" value="${i+1 }"/>
				<tr>
					<td>${i}</td>
					<td>${depositView.depositNumber}</td>
					<td>${depositView.accno}</td>
					<td>${depositView.depositType }</td>
					<td>${depositView.amount}</td>
					<td>${depositView.maturityDate}</td>
					<td>${depositView.rateOfInterest}
					<td>${depositView.tenure}</td>
					<td>${depositView.maturityValue}</td>
					<td>${depositView.depositStatus }</td>
				</tr>
				 </c:forEach>
			</tbody>
			</caption>
		</table>
		<br><br>
		<div class="btn3">
		<button type="submit" class="btn2">
			<a href="customerDashBoard.jsp">Back</a>
		</button>
		</div>
</body>
</html>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Loan Status</title>
<link rel="stylesheet" href="accountDetail.css">
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
	 width:100%;
	padding: 6.5px;
}
nav a {
	padding-right: 80.3px;
	text-decoration:none;
	color:white;
}
nav a:hover{
text-decoration:none;
color:black;}
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
	padding-right:  281px;
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

.t1 {
	padding: 90px;
	padding-left: 350px;
	border: none;
}

td {
	padding-left: 15px;
}

th {
	padding-left: 10px;
	font-size: 17px;
}


.btn2 {
	padding: 5px 15px;
	color: white;
	background-color: green;
	margin-right: 30px;
	border:0;
	border-radius:3px;
}
.btn2 a:hover{
   text-decoration:none;
   color:white;  
}
.btn3 {
	margin-left: 780px;
}

body {
	background-color: rgba(198, 208, 214,.9);
}
.table{
margin-bottom:10px;
 width:950px;
 margin-left:180px;
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

	 
		
		<div class="container mt-4 mb-4">
      <table class="table table-hover table-striped">
          <caption>
			<thead>
				<tr>
					<th>S.no</th>
					<th>AccountNumber</th>
					<th>Name</th>
					<th>Loan Type</th>
					<th>Amount</th>
					<th>Rate of Interest</th>
					<th>Tenure</th>
					<th>Monthly Payment</th>
					<th>Status</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${LoanStatus}" var="LoanStatusView">
				  <c:set var="i" value="${i+1 }"/>
				<tr>
                      <td> ${i} </td>
					<td>${LoanStatusView.accountNumber} </td>
					<td>${LoanStatusView.username} </td>
					<td>${LoanStatusView.loanType}</td>
					<td>${LoanStatusView.loanAmount}</td>
					<td>${LoanStatusView.interestRate}%</td>
					<td>${LoanStatusView.tenure}</td>
					<td>${LoanStatusView.monthlyPayment}</td>
					<td>${LoanStatusView.loanStatus}</td>
				</tr>
				 </c:forEach>
			</tbody>
			</caption>
		</table>
		<br>
		<br>
		<br>
		<div class="btn3">
			<button type="submit" class="btn2">
				<a href="customerDashBoard.jsp">Back</a>
			</button>
		</div>
		</div>
</body>
</html>
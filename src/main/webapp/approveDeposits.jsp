<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"%>
<%@page import="com.bankapp.impl. DepositsDaoimpl"%>
<%@page import="com.bankapp.model.Deposits"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>

<style>
* {
	margin: 0;
	padding: 0;
}


nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87,.9); 
	margin: 0; 
	padding: 4px;
}

nav a {
	padding-right: 61.2px;
}

h1 {
	color: white;
	background: #042331;
	height: 9%;
	margin: 0;
	padding: 2px;
}

a {
	text-decoration: none;
	color: white;
}

.set1 {
	padding-right: 450px;
}

.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
}

h3 {
	padding: 20px;
	background-color: blue;
	margin: 0;
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
}

ul {
	list-style-type: none;
}

.sidebar ul a {
	height: 100%;
	width: 100%;
	line-height: 40px;
	font-size: 15px;
	padding-left: 40px;
	color: white;
}

ul li:hover a {
	padding-left: 50px;
}

.sidebar ul a {
	margin-right: 16px;
}

.box {
	width: 380px;
	height: 700px;
	position: relative;
	margin: 6% auto;
	background: transparent;
	padding: 5px;
	box: shadow;
}

.btn {
	float: right;
	padding: 5px 7px;
	margin-right: 5px;
	border-radius: 7px;
	color: gray;
}

.btn {
	float: right;
	padding: 5px 7px;
	margin-right: 5px;
	border-radius: 7px;
	color: gray;
}

.btn2 {
	padding: 5px 15px;
	background-color: green;
	color: white;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 670px;
}

.btn2 a:hover {
	text-decoration: none;
	color: white;
}

body {
	background-color: rgb(198, 208, 214);
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

.table {
	margin-top: 30px;
	width: 1000px;
	margin-left: 270px;
}

.table th {
	background-color: rgba(161, 15, 95, .5);
}

.table td {
	background-color: rgba(35, 106, 240, .5);
}

.div1 {
	padding-left: 460px;
}

#transhead {
	color: green;
}
</style>
</head>
<body>
	<img src="images/boilogo.png" alt="couldnot load" width="400"
		height="100" />
	<nav>
		<a href="adminDashBoard.jsp"> Home</a>
		  <a href="loans.jsp">Loans</a>
		  <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="register.jsp">Register</a>
		  <a href="login.jsp">Login</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" class="set1">ContactUs</a>
		 
		<button class="btn">
			<a href="LogoutServlet">Logout</a>
		</button>
	</nav>
	<br>
	<br>
	<br>
	<div class="sidebar">

		<header>ADMIN</header>
		<ul>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account Details </a></li>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposits">ApproveDeposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by Account</a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>



		</ul>
	</div>


	
	<div class="container mt-4 mb-4">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>S.no</th>
					<th>DepositNumber</th>
					<th>AccountNumber</th>
					<th>DepositType</th>
					<th>Amount</th>
					<th>Date</th>
					
					<th>Tenure</th>
					<th>Status</th>
					<th>Approve</th>
				</tr>
			</thead>
			<br>
			<br>

			<tbody>
				<c:forEach items="${ApproveDeposit}" var="approvedeposit">
				  <c:set var="i" value="${i+1 }"/>
				<tr>


					<td>${i}</td>
					<td>${approvedeposit.depositNumber}</td>
					<td>${approvedeposit.accno }</td>
					<td>${approvedeposit.depositType }</td>
					<td>${approvedeposit. amount}</td>
					<td>${approvedeposit.maturityDate }</td>
					<td>${approvedeposit.tenure }</td>
					<td>${approvedeposit.depositStatus }</td>
					<td><a
						href="DepositApproveAdmin?accno=${approvedeposit. accno}&status=Approved">Approve</a></td>
				</tr>

				 </c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>
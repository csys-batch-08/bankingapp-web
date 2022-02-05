<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	width: 98.7%;
	padding: 8px;
}

nav a {
	padding-right: 95px;
}

nav a:hover {
	text-decoration: none;
	color: black;
}

a {
	text-decoration: none;
	color: white;
}

.sidebar {
	position: absolute;
	left: 0;
	width: 250px;
	height: 100%;
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

.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float: right;
}

p {
	padding: 10px;
	padding-left: 300px;
	padding-right: 50px;
}

th {
	color: white;
	text-align: justify;
	padding-bottom: 20px;
	padding-left: 70px;
}

td {
	color: white;
	text-align: justify;
	padding-left: 20px;
	padding-bottom: 20px;
}

body {
	background-color: rgba(198, 208, 214, .9);
}

.box {
	width: 380px;
	height: 270px;
	position: relative;
	margin: 5% auto;
	background-color: rgba(98, 116, 128, .5);
	padding: 30px;
	padding-left: 20px;
	box: shadow;
}

h4 {
	color: white;
	text-align: center;
}

.btn2 {
	padding: 5px 5px;
	color: white;
	background-color: green;
	margin-left: 28px;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 150px;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 23px;
}

#thead {
	padding: 1px;
}
</style>
</head>
<body>
	<br>
	<h3 id="head">
		<em> Dharshini Bank</em>
	</h3>
	<br>
	<nav>
		<a href="customerDashBoard.jsp"> Home</a>
	    <a href="loans.jsp">Loans</a>
		<a href="deposits.jsp">Deposits</a> 
		<a href="interest.jsp">Interest	Rate</a> 
		<a href="aboutUs.jsp">About us</a> 
		<a href="contactUs.jsp">ContactUs</a>
		<a href="myProfile.jsp">My Profile</a> 
		<a href="LogoutServlet"><button class="btn">Logout</button></a>
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
	<div class="box">



		<h4>My Profile</h4>
		<table>
			<caption>
				<c:forEach items="${userProfileList}" var="profile">
					<tr>
						<th id="thead1">Name</th>
						<td>${profile.userName}</td>
					</tr>
					<br>
					<tr>
						<th id="thead1">EmailId</th>
						<td>${profile.emailId}</td>
					</tr>
					<br>
					<tr>
						<th id="thead1">Mobile Number</th>
						<td>${profile.mobileNumber}</td>
					</tr>
				</c:forEach>
			</caption>
		</table>

		<br> <br>
		<div class="btn3">
			<a href="customerDashBoard.jsp"><button type="submit"
					class="btn2">Back</button></a>
		</div>
	</div>

</body>
</html>
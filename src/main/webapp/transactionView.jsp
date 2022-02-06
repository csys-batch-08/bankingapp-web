<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Summary</title>
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
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	width: 100%;
	padding: 6px;
}

nav a {
	padding-right: 90px;
}

nav a:hover {
	text-decoration: none;
	color: black;
}

a {
	text-decoration: none;
	color: white;
}

.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float: right;
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

#thead1 {
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

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 23px;
}

.head3 {
	margin-left: 250px;
	font-size: 28px;
}
</style>
</head>
<body>
	<br>
	<h3 id="head">
		<em> Dharshini Bank</em>
	</h3>
	<nav>
		<fmt:bundle basename="com.bankapp.bundle.NavBar" prefix="nav.">
			<a href="customerDashBoard.jsp"><fmt:message key="Home" /></a>
			<a href="loans.jsp"><fmt:message key="Loans" /></a>
			<a href="deposits.jsp"><fmt:message key="Deposits" /> </a>
			<a href="interest.jsp">Interest Rate</a>
			<a href="aboutUs.jsp"><fmt:message key="AboutUs" /></a>
			<a href="contactUs.jsp"><fmt:message key="ContactUS" /></a>
			<a href="MyProfile">My Profile</a>
			<a href="LogoutServlet"><button class="btn">
					<fmt:message key="Logout" />
				</button></a>
		</fmt:bundle>
	</nav>
	<br>
	<br>
	<div class="sidebar">
		<header>${sessionScope.username}</header>
		<ul>
			<li><a href="accountDetail.jsp">Account Details</a></li>
			<li><a href="transferAmount.jsp">Transfer Amount</a></li>
			<li><a href="balance.jsp">Balance </a></li>
			<li><a href="fixedDeposit.jsp">Fixed Deposits</a></li>
			<li><a href="recurringDeposit.jsp">Recurring Deposits</a></li>
			<li><a href="personalLoan.jsp">Personal Loan request</a></li>
			<li><a href="housingLoan.jsp">Housing Loan request</a></li>
			<li><a href="transactionSummary.jsp">Transaction History</a></li>
			<li><a href="depositStatusUser.jsp">Deposit Status</a></li>
			<li><a href="loanStatusUser.jsp">Loan Status</a></li>
		</ul>
	</div>
	<h3 class="head3">Transaction History</h3>
	<div class="container mt-4 mb-4">
		<table class="table table-hover table-striped">
			<caption>
				<thead>
					<tr>
						<th id="thead1">S.no</th>
						<th id="thead1">Sender Account Number</th>
						<th id="thead1">Name </th>
						<th id="thead1">Transaction </th>
						<th id="thead1">Receive Account Number</th>
						<th id="thead1">Amount </th>
						<th id="thead1">Date </th>
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
							<fmt:parseDate value="${Transacviewlist.transactiondate }"
								pattern="yyyy-MM-dd" var="transacDate" type="date" />
							<td><fmt:formatDate value="${transacDate}"
									pattern="dd-MM-yyyy" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</caption>
		</table>
	</div>
	<div class="btn3">
		<a href="customerDashBoard.jsp"><button type="submit" class="btn2">Back </button></a>
	</div>
</body>
</html>
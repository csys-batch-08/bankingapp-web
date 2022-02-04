<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
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
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	padding: 7.4px;
	width: 100%;
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

.set1 {
	padding-right: 450px;
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
	height: 900px;
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
	height: 900px;
	width: 100%;
	line-height: 40px;
	font-size: 14px;
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

.table1 {
	padding: 90px;
	padding-left: 300px;
	border: none;
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
	margin-bottom: 10px;
	width: 1000px;
	margin-left: 160px;
}

#thead {
	padding: 1px;
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
	color: red;
	margin-left: 250px;
	font-size: 21px;
}

h2 {
    text-align:center;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 23px;
}
</style>
</head>
<body>
	<br />
	<h3 id="head">
		<em> Dharshini Bank</em>
	</h3>
	<br />
	<nav>
		   <a href="index.jsp"> Home</a> 
		   <a href="loans.jsp">Loans</a> 
		   <a href="deposits.jsp">Deposits</a> 
		   <a href="interest.jsp">Interest Rate</a>
		   <a href="aboutUs.jsp">About us</a> 
		   <a href="contactUs.jsp">ContactUs</a>
		   <a href="LogoutServlet"><button class="btn">Logout</button></a>
		</nav>
	<br />
	<br />
	<div class="sidebar">
		<header>ADMIN</header>
		<ul>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposit">ApproveDeposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by
					Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account
					Details </a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>
		</ul>
	</div>
	<h2 >Loan Status</h2>
	<div class="container mt-4 mb-4">
		<table class="table table-hover table-striped">
			<caption>
				<thead>
					<tr>
						<th id="thead1">S.no</th>
						<th id="thead1">Account Number</th>
						<th id="thead1">Name</th>
						<th id="thead1">Mobile number</th>
						<th id="thead1">Loan Type</th>
						<th id="thead1">Loan Amount</th>
						<th id="thead1">Tenure</th>
						<th id="thead1">Interest</th>
						<th id="thead1">Monthly Payment</th>
						<th id="thead1">Monthly income</th>
						<th id="thead1">Status</th>
						<th id="thead1">Approve</th>
						<th id="thead1">Reject</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ApproveLoan}" var="approveloan">
						<c:set var="i" value="${i+1 }" />
						<c:set var="approve" value="Approved" scope="page" />
						<c:set var="reject" value="Rejected" scope="page" />
						<tr>
							<td>${i}</td>
							<td>${approveloan.accountNumber}</td>
							<td>${approveloan.username}</td>
							<td>${approveloan.mobno}</td>

							<td>${approveloan.loanType}</td>
							<td>${approveloan.loanAmount}</td>
							<td>${approveloan.tenure}</td>
							<td>${approveloan.interestRate}%</td>
							<td>${approveloan.monthlyPayment}</td>
							<td>${approveloan.salary}</td>
							<td>${approveloan.loanStatus}</td>
							<td><a
								href="approveloan?accno=${approveloan.accountNumber}&status=${approve}&salary=${approveloan.salary}">Approve</a></td>
							<td><a
								href="approveloan?accno=${approveloan.accountNumber}&status=${reject}&salary=${approveloan.salary}">Reject</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</caption>
		</table>
		<c:if test="${sessionScope.loanadmin!=null}">
			<h4 id="transhead">${sessionScope.loanadmin}</h4>
		</c:if>
		<c:remove var="loanadmin" scope="session" />
	</div>

</body>
</html>
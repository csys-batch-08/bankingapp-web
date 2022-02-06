<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	width: 98.8%;
	padding: 8px;
}

nav a {
	padding-right: 95.5px;
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
	padding-right: 520px;
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
	height: 96%;
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

.btn1 {
	color: black;
	padding: 50px;
	padding-left: 350px
}

p {
	padding: 10px;
	padding-left: 300px;
	padding-right: 50px;
}

.t1 {
	margin-right: 370px;
	margin-bottom: 7px;
	font-size: 19px;
}

td {
	padding-left: 90px;
}

#thead1 {
	padding-left: 440px;
	text-align: justify;
}

a {
	text-decoration: none;
	color: white;
}

.btn2 {
	padding: 3px;
	color: white;
	background-color: green;
	border: 0;
	border-radius: 3px;
}

.btn2 a:hover {
	color: pink;
	text-decoration: none;
}

.btn3 {
	margin-left: 840px;
}

body {
	background-color: rgb(198, 208, 214);
}

h3 {
	margin-left: 250px;
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
	<br>
	<h3 id="head">
		<em> Dharshini Bank</em>
	</h3>
	<br>
	<nav>
		<a href="customerDashBoard.jsp">Home</a> 
		<a href="loans.jsp">Loans</a>
		<a href="deposits.jsp">Deposits</a> 
		<a href="interest.jsp">Interest Rate</a> 
		<a href="aboutUs.jsp">About us</a> 
		<a href="contactUs.jsp">ContactUs</a>
		<a href="myProfile.jsp">My Profile</a> 
		<a href="LogoutServlet"><button	class="btn">Logout</button></a>

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
	<h3>Account Details</h3>
	<br>
	<br>
	<div class="t1">
		<table>
			<caption>
				<c:forEach items="${AccountDetail}" var="AccountDetails">
					<tr>
						<th id="thead1"><label for="accountType">Account Type</label></th>
						<td>${AccountDetails.accountType}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="accountHolderName">Account Holder Name</label></th>
						<td>${AccountDetails.accountHolderName}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="address">Address </label></th>
						<td>${AccountDetails.address}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="city">City </label></th>
						<td>${AccountDetails.city}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="pinCode">Pin Code</label></th>
						<td>${AccountDetails.pincode}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="dob">Date Of Birth</label></th>
						<fmt:parseDate value="${AccountDetails.dob}" pattern="yyyy-MM-dd"
							var="dob" type="date" />
						<td><fmt:formatDate value="${dob}" pattern="dd-MM-yyyy" /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="mobile">Mobile number</label></th>
						<td>${AccountDetails.mobileNumber}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="email">Email Id</label></th>
						<td>${AccountDetails. email}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="ifscCode">IFSC code</label></th>
						<td>${AccountDetails.ifscCode}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="branchName">Branch Name</label></th>
						<td>${AccountDetails.branchName}</td>
					</tr>
					<tr>
						<th id="thead1"><label for="pan">Pan Number</label></th>
						<td>${AccountDetails.pan }</td>
					</tr>
				</c:forEach>
			</caption>
		</table>
		<div class="btn3">

			<a href="customerDashBoard.jsp"><button type="submit"
					class="btn2">Back</button></a>

		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Housing Loan</title>

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
	margin: 3% auto;
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

.cls {
	border-radius: 3px;
	padding: 5px 5px 5px 5px;
	Background-color: transparent;
}

.btn2 {
	padding: 3px;
	color: white;
	background-color: green;
	margin-right: 30px;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 150px;
}

body {
	background-color: rgba(198, 208, 214, .9);
}

#set2 {
	margin-left: 250px;
}

td {
	padding-left: 20px;
	text-align: justify;
	padding-bottom: 8px;
}

#thead1 {
	text-align: justify;
	padding-left: 30px;
	padding-bottom: 8px;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 23px;
}

#transhead {
	color: green;
}

#transheads {
	color: red;
}

.set2 {
	color: black;
	font-size: 18px;
	margin-left: 250px;
}

h2 {
	text-align: center;
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

	<h2>Housing Loan</h2>
	<br>
	<h4 id="set2">Note : Please Save Loan Number for future Use!</h4>
	<div class="box">
		<form action="House" method="post">
			<table>

				<tr>
					<th id="thead1"><label for="lname">Name </label></th>
					<td><input type="text" class="cls" name="lname" id="lname"
						pattern="[a-zA-z]{3,}" required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="dob">Date Of Birth</label></th>
					<td><input type="date" class="cls" name="dob" id="dob"
						required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="address">Address </label></th>
					<td><input type="text" class="cls" name="address" id="address"
						pattern="[a-zA-z0-9,-]+" required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="email">Email </label></th>
					<td><input type="email" class="cls" name="email" id="email"
						required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="mobno">Mobile Number</label></th>
					<td><input type="text" class="cls" name="mobno" id="mobno"
						pattern="[6-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="amountDeposit">Loan Amount</label></th>
					<td><input type="text" name="amountDeposit" class="cls"
						id="amountDeposit" pattern="[1-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="tenure">Tenure </label></th>
					<td><input type="text" name="period" id="period"
						pattern="[1-9]+" class="cls" placeholder="TENURE IN YEARS"
						required /></td>
				</tr>
				<tr>
					<th id="thead1"><label for="pan">Pan number</label></th>
					<td><input type="text" name="pan" id="pan" class="cls"
						required /></td>
				</tr>

			</table>
			<br> <br>
			<div class="btn3">
				<button type="submit" name="submit" class="btn2">Submit</button>
				<button type="reset" name="reset" class="btn2">Reset</button>
			</div>
			<br> <br>
		</form>
		<c:if test="${sessionScope.Hloan!=null}">
			<h4>${sessionScope.Hloan}</h4>
			<h4 id="transhead">Your Loan Number: ${sessionScope.Hloan1}</h4>
		</c:if>
		<c:remove var="Hloan" scope="session" />
		<c:remove var="Hloan1" scope="session" />
		<c:if test="${sessionScope.HloanNot!=null}">
			<h4>${sessionScope.HloanNot}</h4>
		</c:if>
		<c:remove var="HloanNot" scope="session" />
		<c:if test="${sessionScope.Houloan!=null}">
			<h4>${sessionScope.Houloan}</h4>
		</c:if>
		<c:remove var="Houloan" scope="session" />

	</div>

</body>
</html>
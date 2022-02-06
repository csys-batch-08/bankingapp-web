<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<style>
* {
	margin: 0;
	padding: 0;
}

#navbar {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	margin: 0;
	padding: 7.5px;
	width: 98.9%;
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
	padding-right: 623.5px;
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
	height: 700px;
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

.cls {
	border-radius: 3px;
	padding: 5px 5px 5px 5px;
	Background-color: transparent;
}

.btn2 {
	padding: 5px;
	color: white;
	background-color: green;
	margin-right: 30px;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 160px;
}

h2 {
	text-align: center;
}

body {
	background-color: rgba(198, 208, 214, .9);
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

.div1 {
	padding-left: 460px;
}

#transhead {
	color: green;
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
	<nav id="navbar">
		    <a href="index.jsp" target="_self"> Home</a>
		    <a href="loans.jsp" target="_self">Loan</a>
		    <a href="deposits.jsp" target="_self">Deposit</a>
		    <a href="interest.jsp" target="_self">Interest Rate</a>
		    <a href="aboutUs.jsp" target="_self">About us</a>
		    <a href="contactUs.jsp" target="_self">Contact Us</a>
		    <a href="LogoutServlet" target="_self"><button class="btn">Log Out</button></a>
	</nav>
	<br />
	<br />
	<div class="sidebar">
		<header>ADMIN</header>
		<ul>
			<li><a href="ApproveLoans" target="_self">Approve Loans</a></li>
			<li><a href="ApproveDeposit" target="_self">Approve Deposits</a></li>
			<li><a href="InterestRate" target="_self">Rate Of Interest</a></li>
			<li><a href="ViewAllUser" target="_self">View All Users</a></li>
			<li><a href="ViewAllAccount" target="_self">View All Account</a></li>
			<li><a href="transactionByDate.jsp" target="_self">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp" target="_self">Transaction by
					Account</a></li>
			<li><a href="adminAddAccount.jsp" target="_self">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp" target="_self">Update Account
					Details </a></li>
			<li><a href="userCancel.jsp" target="_self">Cancel Account</a></li>
		</ul>
	</div>
	<h1></h1>
	<h2>Add Account</h2>
	<br/>
	<div class="div1">
		<form action="addAccount" method="post">
			<table>
				 <caption>
					<tr>
						<th id="thead1"><label for="accountType">Enter Account Type</label></th>
						<td><input type="text" class="cls" name="accountType" id="accountType" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="accountHoldName">Enter Account Holder Name</label></th>
						<td><input type="text" class="cls"  id="accountHoldName" name="accountHoldName"
							pattern="[A-Za-z]{5,}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="address">Enter Address</label></th>
						<td><input type="text" class="cls" name="address" id="address"
							pattern="[A-Za-z0-9]{5,}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="city">Enter City</label></th>
						<td><input type="text" name="city" class="cls" id="city"
							pattern="[A-Za-z]{3,}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="pincode">Enter Pin Code</label></th>
						<td><input type="text" class="cls" name="pincode" id="pincode"
							pattern="[0-9]{6}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="dob">Enter Date of Birth</label></th>
						<td><input type="date" class="cls" name="date" id="date"
							placeholder="dd-mm-yyyy" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="mobile">Enter Mobile Number</label></th>
						<td><input type="text" class="cls" name="mobile" id="mobile"
							pattern="[6-9][0-9]{9}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="email">Enter Email</label></th>
						<td><input type="email" class="cls" name="email" id="email"
							pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="ifscCode">Enter IfscCode</label></th>
						<td><input type="text" class="cls" name="ifscCode" id="ifscCode" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="branchName">Enter Branch Name</label></th>
						<td><input type="text" class="cls" name="branchName" id="branchName"
							pattern="[A-Za-z]{3,}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="balance">Enter Balance</label></th>
						<td><input type="text" class="cls" name="balance"  id="balance" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="pin">Enter Pin Number</label></th>
						<td><input type="text" class="cls" name="pin" id="pin"
							pattern="[0-9]{4}" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="status">Enter Status</label></th>
						<td><input type="text" class="cls" name="status" id="status"
							placeholder="ACTIVE OR INACTIVE" required /></td>
					</tr>
					<tr>
						<th id="thead1"><label for="pan">Enter Pan Number</label></th>
						<td><input type="text" class="cls" name="pan"  id="pan" required /></td>
					</tr>
				</caption>
			</table>
			<br/>
			<div class="btn3">
				<button type="submit" class="btn2">Submit</button>
			</div>
			<br/> <br/>
		</form>
	</div>

</body>
</html>
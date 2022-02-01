<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87,.9);
  	padding:7px;
	width:98.9%;
}
nav a {
	padding-right: 95.2px;
}
a {
	text-decoration: none;
	color: white;
}
.set {
	 margin-left:280px;
}
.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 16px;
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
	border:0;
	border-radius:3px;
}
.btn3 {
	margin-left: 170px;
}
body {
	background-color: rgba(198, 208, 214,.9);
}
td {
	padding-left: 20px;
	text-align: justify;
	padding-bottom: 15px;
}

th {
	text-align: justify;
	padding-left: 30px;
	padding-bottom: 15px;
}
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
	</nav><br>	<br>
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
	<h2 class="set" >Check Balance</h2>
	<div class="box">
		<form action="Balance" method="post">
			<table>
				<tr>
					<th><label for="accountNum" name="accNum"> Account Number</label></th>
					<td><input type="text" class="cls" name="accno" pattern="[0-9]{12}"
						required autofocus /></td>
				</tr>
				<tr>
					<th><label for="pinNum" name="pinNum">Pin Number</label></th>
					<td><input type="password"  class="cls" name="pin" pattern="[0-9]{4}"
						required /></td>
				</tr>
			</table><br> 
			<div class="btn3">
			<button type="submit" class="btn2">Submit</button>
			<button type="reset" class="btn2">Reset</button>
			</div>
		</form>
	</div>
	  <c:if test="${sessionScope.pinvalidate!=null}">
          <h4>${sessionScope.pinvalidate}</h4>
          </c:if> 
        <c:remove var="pinvalidate" scope="session"/>
</body>
</html>
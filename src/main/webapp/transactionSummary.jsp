<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Summary</title>

<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87,.9);
    width:99%;
	padding: 3.5px;
}
nav a {
	padding-right:  99px;
}
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
	padding-right: 325.5px;
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
	position:absolute;
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

.btn {
	float: right;
	padding: 5px 7px;
	margin-right: 5px;
	border-radius: 7px;
	color: gray;
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
	margin-left: 150px;
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
#transhead
{
color:red;}
</style>
</head>
<body>
	<img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
	<nav>
		 <a href="customerDashBoard.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		  <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="myProfile.jsp">My Profile</a>
		<button class="btn">
			<a href="LogoutServlet">Logout</a>
		</button>
	</nav>
	<br>
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
 
	</button>
	<h2 align="center">Transaction Summary</h2>
	<div class="box">
		<form action="transac" method="post">
			<table>
				<tr>
					<th> Account Number</th>
					<td><input type="text"  class="cls"  name="accno" required
						pattern="[0-9]{12}" /></td>
				</tr>
				<tr>
					<th>Pin Number</th>
					<td><input type="password" class="cls" name="pin" required
						pattern="[0-9]{4}" /></td>
				</tr>
 
			</table><br><br>
			<div class="btn3">
			<button type="submit" class="btn2" >Submit</button>
			<button type="reset" class="btn2">Reset</button>
			</div>
			
		</form>
		 <c:if test="${sessionScope.pinvalidate!=null}">
          <h4>${sessionScope.pinvalidate}</h4>
          </c:if> 
            
           <c:remove var="pinvalidate" scope="session"/>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interest Rate</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 17px;
	color: black;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	height: 25%;
	margin: 0;
	padding: 7px;
}

nav a {
	padding-right: 77.5px;
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
	font-size: 13px;
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

.t1 {
	padding: 40px;
	padding-left: 350px;
	border: none;
}

 

.cls {
	border-radius: 3px;
	padding: 5px 5px 5px 5px;
	Background-color: transparent;
}

.table1 {
	padding: 90px;
	padding-left: 300px;
	border: none;
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
.btn2 a:hover{
text-decoration:none;
color:white;}
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

</style>
</head>
<body>
	<img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
	<nav>
		<a href="index.jsp"> Home</a> <a href="loans.jsp">Loans</a> <a
			href="deposits.jsp">Deposits</a> <a href="AboutUs.jsp">About us</a> <a
			href="ContactUs.jsp">Contact Us</a> <a href="interest.jsp"
			class="set1">%</a>

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
			<li><a href="viewAllUser.jsp">View All Users</a></li>
			<li><a href="viewAccount.jsp">View All Account</a></li>
			<li><a href="AdminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="UpdateAccountDetails.jsp">Update Account
					Details </a></li>
			<li><a href="ApproveLoans.jsp">ApproveLoans</a></li>
			<li><a href="ApproveDeposits.jsp">ApproveDeposits</a></li>
			<li><a href="InterestRateAll.jsp">Rate Of Interest</a></li>
			<li><a href="TransactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="TransactionByAcc.jsp">Transaction by Account</a></li>
			<li><a href="UserCancel.jsp">Cancel Account</a></li>



		</ul>
	</div>


	<h3 align="center">Change Rate of Interest</h3>
	<div class="box">
		<form action="interestRate" method="post">
				<table>
				<tr>
					<th>Enter DescriptionId</th>
					<td><input type="text" name="desc" class="cls" required /></td>
				</tr>

				<tr>
					<th>Enter InterestRate</th>
					<td><input type="text" class="cls" name="rate" required /></td>
				</tr>
			</table>
			<br>

			<div class="btn3">

				<button type="submit" class="btn2">Submit</button>
				<button type="submit" class="btn2">
					<a href="InterestRateAll.jsp">Back</a>
				</button>
			</div>
			 
		</form>
		<%!String flag;%>
		<%
		if (session.getAttribute("rat") != null) {
			flag = session.getAttribute("rat").toString();
		%>


		<h4 id="transhead"><%=flag%></h4>
		<%
		}
		%>
		<%
		session.removeAttribute("rat");
		%>
	</div>

</body>
</html>
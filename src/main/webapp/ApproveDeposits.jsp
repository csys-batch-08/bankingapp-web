<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"%>
<%@page import="com.bankapp.impl. DepositsDaoimpl"%>
<%@page import="com.bankapp.model.Deposits"%>
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
	color: black;
	float: left;
	background-color: rgba(9, 57, 87,.9);
	height: 25%;
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
		<a href="index.jsp"> Home</a> <a href="loans.jsp">Loans</a> <a
			href="deposits.jsp">Deposits</a> <a href="AboutUs.jsp">About us</a> <a
			href="ContactUs.jsp">Contact Us</a> <a href="interest.jsp"
			class="set1">%</a> <a href="MyProfile.jsp">My Profile</a>
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


	<%
	DepositsDaoimpl depositDao = new DepositsDaoimpl();
	List<Deposits> List = new ArrayList<Deposits>();
	List = depositDao.viewdeposit();
	%>

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
				<%
				int i = 0;
				for (Deposits viewuser : List) {
					i++;
				%>
				<tr>


					<td><%=i%></td>
					<td><%=viewuser.getDepositNumber()%>
					<td><%=viewuser.getAccno()%></td>
					<td><%=viewuser.getDeposit_type()%></td>
					<td><%=viewuser.getAmount()%></td>
					<td><%=viewuser. getDate_of_deposit()%></td>
					<td><%=viewuser.getTenure()%></td>
					<td><%=viewuser.getDeposit_status()%></td>
					<td><a
						href="DepositApproveAdmin?accno=<%=viewuser.getDepositNumber()%>&status=Approved">Approve</a></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>

	</div>

</body>
</html>
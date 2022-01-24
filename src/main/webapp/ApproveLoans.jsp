<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"%>
<%@page import="com.bankapp.impl. LoansDaoimpl"%>
<%@page import="com.bankapp.model.Loans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>

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
	background-color: rgba(9, 57, 87,.9);
	height: 25%;
	margin: 0;
	 
	padding: 6.5px;
}

nav a {
	padding-right: 79px;
}
nav a:hover{
text-decoration:none;
color:white;}

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

.btn {
	float: right;
	padding: 5px 7px;
	margin-right: 5px;
	border-radius: 7px;
	color: gray;
}

.table1 {
	padding: 90px;
	padding-left: 300px;
	border: none;
}

.btn2{
	 padding:5px 15px;
	 background-color:green;
	 color:white;
	 border:0;
	 border-radius:3px;
}

.btn3 {
	margin-left: 670px;
}
.btn2 a:hover{
text-decoration:none;
color:white;}
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
.table{
margin-bottom:10px;
 width:1000px;
 margin-left:180px;
}
.table th{
background-color:  rgba(161, 15, 95,.5);}
.table td{
background-color:  rgba(35, 106, 240,.5);}

.div1 {
	padding-left: 460px;
}

#transhead {
	color: green;
}
</style>
</head>
<body>
	<img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
	<nav>
		<a href="index.jsp"> Home</a>
		 <a href="loans.jsp">Loans</a> <a
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
	<h2 align="center">Loan Status</h2>

	<%
	LoansDaoimpl LoanDao = new LoansDaoimpl();
	List<Loans> List = new ArrayList<Loans>();
	List = LoanDao.viewloan();
	%>

	 <div class="container mt-4 mb-4">
      <table class="table table-hover table-striped">

			<thead>
				<tr>
					<th>S.no</th>

					<th>AccountNumber</th>
					<th>Name</th>
					<th>Mobile number</th>
					<th>LoanType</th>
					<th>LoanAmount</th>
					<th>Tenure</th>
					<th>Interest</th>
					<th>Status</th>
					<th>Approve</th>
					<th>Reject</th>
				</tr>
			</thead>
			 

			<tbody>
				<%
				int i = 0;
				for (Loans viewuser : List) {
					i++;
				%>
				<tr>


					<td><%=i%></td>

					<td><%=viewuser.getAccount_number()%></td>
					<td><%=viewuser.getUser_name()%></td>
					<td><%=viewuser.getMobno()%></td>
					<td><%=viewuser.getLoan_type()%></td>
					<td><%=viewuser.getLoan_amount()%></td>
					<td><%=viewuser.getTenure()%></td>
					<td><%=viewuser.getInterest_rate()%></td>
					<td><%=viewuser.getLoan_status()%></td>
					<td><a
						href="approveloan?accno=<%=viewuser.getAccount_number()%>&status=<%="Approved"%>">Approve</a></td>
					<td><a
						href="approveloan?accno=<%=viewuser.getAccount_number()%>&status=<%="Rejected"%>">Reject</a></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>

	</div>
	</div>
	</div>

</body>
</html>
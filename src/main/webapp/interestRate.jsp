<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
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
	width:100%;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	padding: 7.4px;
}
nav a {
	padding-right: 95px;
}
nav a:hover{
text-decoration:none;
color:black;}a {
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
		<a href="index.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		 <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" >ContactUs</a>
		<button class="btn"><a href="LogoutServlet">Logout</a></button>
	</nav><br><br>
	<div class="sidebar">

		<header>ADMIN</header>
		<ul>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposit">ApproveDeposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account Details </a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li></ul>
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
					<a href="adminDashBoard.jsp">Back</a>
				</button>
			</div>
			 
		</form>
		 <c:if test="${sessionScope.rat!=null}">
          <h4>${sessionScope.rat}</h4>
          </c:if> 
            
           <c:remove var="rat" scope="session"/>
	</div>

</body>
</html>
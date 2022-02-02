<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title> Add Account</title>
<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 17px; 
	float: left;
	background-color: rgba(9, 57, 87,.9);
	margin: 0;
	padding: 7.5px;
	width:98.9%;
}
nav a {
	padding-right: 95px;
}
nav a:hover{
text-decoration:none;
color:black;}
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
	float:right;
}
.sidebar {
	position:absolute;
	left: 0;
	width: 250px;
	height: 700px;
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
	border:0;
	border-radius:3px;
}
.btn3 {
	margin-left: 160px;
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
.div1{
padding-left :460px;}
#transhead{
color:green;}
#head{
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
  font-size:23px;
 }
 </style>
</head>
<body>
	 <br/> <h3 id="head"><i> Dharshini Bank</i></h3><br/>
	<nav>
		<a href="index.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		 <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" >ContactUs</a>
		<button class="btn"><a href="LogoutServlet">Logout</a></button>
	</nav><br/><br/> 
	<div class="sidebar">
		<header>ADMIN</header>
		<ul>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account Details </a></li>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposits">ApproveDeposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by Account</a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>
		</ul>
	</div>
	<h2 align="center">Add Account</h2><br/>
	<div class="div1">
		<form action="addAccount" method="post">
			<table>
				<tr>
					<th>Enter Account Type</th>
					<td><input type="text" class="cls"  name="type" required /></td>
				</tr>
				<tr>
					<th>Enter Account Holder Name</th>
					<td><input type="text" class="cls"  name="aname" pattern="[A-Za-z]{5,}"
						required /></td>
				</tr>
				<tr>
					<th>Enter Address</th>
					<td><input type="text" class="cls" name="address"
						pattern="[A-Za-z0-9]{5,}" required /></td>
				</tr>
				<tr>
					<th>Enter City</th>
					<td><input type="text" name="city" class="cls"  pattern="[A-Za-z]{3,}"
						required /></td>
				</tr>
				<tr>
					<th>Enter Pincode</th>
					<td><input type="text"  class="cls" name="pincode" pattern="[0-9]{6}"
						required /></td>
				</tr>
				<tr>
					<th>Enter Date of Birth</th>
					<td><input type="date" class="cls" name="date" placeholder="dd-mm-yyyy"
						required /></td>
				</tr>
				<tr>
					<th>Enter Mobile Number</th>
					<td><input type="text" class="cls" name="mobno" pattern="[6-9][0-9]{9}"
						required /></td>
				</tr>
				<tr>
					<th>Enter Email</th>
					<td><input type="email" class="cls" name="email"
						pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required /></td>
				</tr>
				<tr>
					<th>Enter Ifsc code</th>
					<td><input type="text"  class="cls" name="code" required /></td>
				</tr>
				<tr>
					<th>Enter Branch Name</th>
					<td><input type="text" class="cls" name="branch" pattern="[A-Za-z]{3,}"
						required /></td>
				</tr>
				<tr>
					<th>Enter Balance</th>
					<td><input type="text" class="cls" name="balance" required /></td>
				</tr>
				<tr>
					<th>Enter Pin Number</th>
					<td><input type="text" class="cls" name="pin" pattern="[0-9]{4}" required /></td>
				</tr>
				<tr>
					<th>Enter Status</th>
					<td><input type="text" class="cls" name="status"
						placeholder="ACTIVE OR INACTIVE" required /></td>
				</tr>
				<tr>
					<th>Enter  Pan Number</th>
					<td><input type="text" class="cls" name="pan"
						 required /></td>
				</tr>
			</table>
			<br/>
			<div class="btn3">
			<button type="Submit" class="btn2">Submit</button>
			</div>
			<br/> <br/>
		</form>
</div>
</body>
</html>
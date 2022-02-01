 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 <style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 17px;
 	float: left;
	background-color: rgba(9, 57, 87,.9);
	padding: 3px;
	width:99.8%;
}
nav a {
	padding-right: 95.2px;
	text-decoration: none;
	color: white;
}
nav a:hover{
text-decoration:none;
color:white;}
  .btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float:right;
}
 .sidebar {
	position: absolute;
	left: 0;
	width: 250px;
	height: 96%;
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
	text-decoration:none;
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
.t1{
  margin-right:350px;
 margin-bottom:7px;
 font-size:19px;
}
 td {
	padding-left: 90px;
}
th {
	padding-left: 440px
}
a{
text-decoration:none;
color:white;}
.btn2   {
	padding: 3px;
	color:white;
	 background-color:green;
	 border:0;
	 border-radius:3px;
}
.btn2 a:hover{
color:pink;
text-decoration:none;}
.btn3 {
	margin-left: 840px;
}
body {
	background-color: rgb(198, 208, 214);
}
h3{
margin-left:250px;}
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
	</nav><br><br>
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
     <h3 >Account Details</h3>
      <div class="t1">
  <table >
  <caption>
 <c:forEach items="${AccountDetail}" var="AccountDetails">
   <tr>
   <th>AccountType</th>
   <td>${AccountDetails.accountType}</td>
   </tr>
   <tr>
   <th>AccountHolderName</th>
   <td>${AccountDetails.accountHolderName}</td>
   </tr>
   <tr>
   <th>AccountBalance</th>
   <td>${AccountDetails.balance}</td>
   </tr>
   <tr>
   <th>AccountAddress</th>
   <td>${AccountDetails.address}</td>
   </tr>
     <th >City</th>
   <td>${AccountDetails.city}</td>
   </tr>
    <th >PinCode</th>
    <td>${AccountDetails.pincode}</td>
   </tr>
    <th >DOB</th>
   <td>${AccountDetails.dob}</td>
   </tr>
    <th >Mobile number</th>
   <td>${AccountDetails.mobileNumber}</td>
   </tr>
    <th >Email</th>
   <td>${AccountDetails. email}</td>
   </tr>
    <th >IFSC code</th>
   <td>${AccountDetails.ifscCode}</td>
   </tr>
    <th >Branch Name</th>
   <td>${AccountDetails.branchName}</td>
   </tr>
   </tr>
    <th >Pan Number</th>
   <td>${AccountDetails.pan }</td>
   </tr>
   </c:forEach>
   </caption>
    </table>
     <div class="btn3">
    <button type="submit" class="btn2" ><a href="customerDashBoard.jsp">Back</a></button>
        </div>
   </div>
</body>
</html>
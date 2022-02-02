<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import = "java.util.List" import = "java.util.ArrayList" %>
     <%@page import="com.bankapp.impl.AccountDetailsdaoimpl"%>
    <%@page import="com.bankapp.model. *"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>All Account</title>
<link href="asserts/css/adminStyles.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <style>
 a{
 text-decoration:none;
 color:white;
 }
body {
	background-color:rgba(198, 208, 214,.9);
}
.btn3 {
	margin-left: 670px;
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
 width:200px;
 margin-left:150px;
 font-size:15px;
}
.table th{
background-color:  rgba(161, 15, 95,.5);}
.table td{
background-color:  rgba(35, 106, 240,.5);}
#transhead{
color:green;}
.div1{
padding-left:240px
}
 </style>
</head>
<body>
	 <br> <h3 id="head"><i> Dharshini Bank</i></h3>
	<nav>
		<a href="index.jsp"> Home</a>
		<a href="loans.jsp">Loans</a>
		 <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" >ContactUs</a>
		<button class="btn"><a href="LogoutServlet">Logout</a></button>
	</nav>
	<br>
	<br>
	 	<div class="sidebar">

		<header>ADMIN</header>
		<ul>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account Details </a></li>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposit">ApproveDeposit</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by Account</a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>



		</ul>
	</div>
	
	

<div class="container mt-4 mb-4">
      <table class="table table-hover table-striped">
      <caption>
<thead>
<tr>
  <th>S.no</th>
  <th>Account Number</th>
  <th>Account Holder Name</th>
 <th>Account Type</th>
 <th>Mobile Number</th>
<th> Email</th>
<th>IFSC code</th>
<th>Branch Name</th>
<th>Status</th>
<th>Pan Number</th>
</tr>
</thead>
 

<tbody>
 <c:forEach items="${ViewAccount}" var="viewAccount">
		  <c:set var="i" value="${i+1 }"/>
<tr>

<td>${i}</td>
<td>${viewAccount.accountNumber }  </td>
<td>${viewAccount.accountHolderName }  </td>
<td>${viewAccount. accountType}  </td>
<td>${viewAccount.mobileNumber }  </td>
<td>${viewAccount.email }  </td>
<td>${viewAccount.ifscCode }  </td>
<td>${viewAccount.branchName }  </td>
<td>${viewAccount. status}  </td>
<td>${viewAccount.pan }  </td>
 </tr>
 </c:forEach>
</tbody>
</caption>
          </table><br>
          </div>
          <div class="btn3">
		<button type="submit" class="btn2"><a href="adminDashBoard.jsp">Back</a></button>
		</div>
		 

          
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import = "java.util.List" import = "java.util.ArrayList"%>
    <%@page import="com.bankapp.impl.TransactionDaoimpl"%>
    <%@page import="com.bankapp.model.Transaction"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 17px;
 	float: left;
	background-color: rgba(9, 57, 87,.9);
	 width:100%;
	padding: 7px;
}
nav a {
	padding-right: 79px;
}
nav a:hover{
text-decoration:none;
color:black;}
 a {
	text-decoration: none;
	color: white;
}
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
	height: 1200px;
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
.box{
        width:380px;
        height:700px;
        position:relative;
        margin:6% auto; 
        background: transparent;
        padding:5px;
        box:shadow;
   }
 .t1 {
	padding: 40px;
	padding-left: 350px;
	border:none;
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
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account Details </a></li>
			<li><a href="ApproveLoans">ApproveLoans</a></li>
			<li><a href="ApproveDeposit">ApproveDeposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by Account</a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>
			
			 
			 
		</ul>
     </div>
      
     
     <h2 align="center">Transaction</h2>
      
     

 <div class="container mt-4 mb-4">
      <table class="table table-hover table-striped">
<thead>
<tr>
  <th>S.no</th>
  <th>Sender Account Number</th>
 <th>Name</th>
 <th>Transaction</th>
<th>Receive Account Number</th>
<th>Amount</th>
<th>Transaction Date</th>
</tr>
</thead>
 

<tbody>
 <c:forEach items="${transacAcc}" var="TransactionAccount">
				  <c:set var="i" value="${i+1 }"/>
<tr>


<td>${i }</td>
<td>${TransactionAccount. senderAccountNumber} </td>
<td>${TransactionAccount. name} </td>
<td>${TransactionAccount.transactionType }</td>
 <td>${TransactionAccount. receiveAccountNumber} </td>
 <td>${TransactionAccount.amount } </td>
 <td>${TransactionAccount.transactiondate } </td>
 </tr>

 </c:forEach>
</tbody>
          </table><br><br>
          <div class="btn3">
          <button type="submit" class="btn2"><a href="TransactionByAcc.jsp">Back</a></button>
          </div>
     </div>
     
</body>
</html>
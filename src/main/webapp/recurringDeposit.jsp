<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>RECURRING DEPOSITS</title>
<style>
* {
	margin: 0;
	padding: 0;
}
nav {
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87,.9);
    width:98.8%;
	padding: 8px;
}
nav a {
	padding-right: 95.5px;
}
nav a:hover{
text-decoration:none;
color:black;}
a {
	text-decoration: none;
	color: white;
}
.set1 {
	padding-right: 520px;
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
	height: 96%;
	background-color: rgba(9, 57, 87,.8 );
	color: white;
}
.sidebar header {
	font-size: 15px;
	color: white;
	text-align: center;
	line-height: 50px;
background-color: rgba(9, 57, 87,.3 );
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
#head{
  font-family:  Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
  font-size:23px;
 }
 #transhead{
 color:green;}
 #transheads{
 color:red;}
  .set2{
 color:black;
 font-size:18px;
 margin-left:250px;}
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
	</nav>
	<br>
	<br>
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
	 
	<h2 align="center">RECURRING DEPOSITS</h2>
	<div class="box">
		<form - action="Recurring" method="post">
			<table>
			 <tr>
					<th><label for="account">Account Number</label></th>
					<td><input type="text" name="accNo" class="cls"
						pattern="[0-9]{12,14}" required autofocus /></td>
				</tr>
				<tr>
					<th><label for="amount"> Total Amount  </label></th>
					<td><input type="text" name="amountDeposit"
						class="cls" pattern="[1-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th><label for="amount"> Monthly Deposit</label></th>
					<td><input type="text" name="monthlyDeposit"
						class="cls" pattern="[1-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th> <label for="tenure">Tenure</label></th>
					<td><input type="text" class="cls"  name="period" pattern="[1-9]+"
						required placeholder="TENURE IN YEARS" /></td>
				</tr>
				 <tr>
                    <th><label for="pan">Pan Number</label></th>
                    <td><input type="text" name="pan" pattern="[a-zA-z0-9]+" class="cls" required "/></td>
                 </tr>
			</table><br><br>
			<div class="btn3">
			<button type="submit" class="btn2">Submit</button>
			<button type="reset" class="btn2">Reset</button>
			</div>
			<br>
			<br>
		</form>
		<h4 id="set2">Note<sup id="transheads">*</sup>:Please Save Deposit Number for future Use   </h4>
		 <c:if test="${sessionScope.rd1!=null}">
          <h4 id= "transhead">${sessionScope.rd1}</h4>
          </c:if> 
          <c:remove var="rd1" scope="session"/>
              <c:if test="${sessionScope.rd2!=null}">
          <h4 id= "transhead">${sessionScope.rd2}</h4>
          </c:if> 
            
           <c:remove var="rd2" scope="session"/>
           
             <c:if test="${sessionScope.rd!=null}">
          <h4 id= "transheads">${sessionScope.rd}</h4>
          </c:if> 
            
           <c:remove var="rd" scope="session"/>
	</div>
	 
</body>
</html>
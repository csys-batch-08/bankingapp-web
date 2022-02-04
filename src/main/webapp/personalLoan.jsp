<%@ page language="java" contentType="text/html charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>PERSONAL LOAN</title>
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
	height: 900px;
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
	margin: 3% auto;
	background: transparent;
	padding: 5px;
	box: shadow;
}
 .pa {
	text-align: left;
}
.par {
	padding: 15px;
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
#set2{
margin-left:250px;}
#transhead{
color:green;
}
#transhead1{
color:red;}
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
	 
	<h2 align="center">PERSONAL LOAN</h2><br>
	<h4 id="set2">Note : If Applied for loan,Please Save <span id="transhead">Loan Number </span>for future Use!   </h4>
	<div class="box">
		<form action="Personal" method="post">
			<table>
			<caption>
			<tr>
					<th><label for="name">Name</label></th>
					<td><input type="text"  class="cls" name="lname"
						pattern="[a-zA-z]{3,}" required /></td>
				</tr>
				<tr>
					<th><label for="dob">DOB</label></th>
					<td><input type="date"  class="cls" name="dob"
						  required /></td>
				</tr>
				<tr>
					<th><label for="address">Address</label></th>
					<td><input type="text"  class="cls" name="address"
						pattern="[a-zA-z0-9,-]+" required /></td>
				</tr>
				<tr>
					<th><label for="email">Email</label></th>
					<td><input type="email"  class="cls" name="email"
						  required /></td>
				</tr>
				<tr>
					<th><label for="mobNo">MobileNumber</label></th>
					<td><input type="text"  class="cls" name="mobno"
						pattern="[6-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th><label for="loanAmount">  Loan Amount</label></th>
					<td><input type="text"  class="cls" name="amountDeposit"
						pattern="[1-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th> <label for="tenure"> Tenure</label></th>
					<td><input type="text" name="period" pattern="[1-9]+"
						class="cls" placeholder="TENURE IN YEARS" required /></td>
				</tr>
				<tr>
					<th> <label for="type"> Working Type</label></th>
					<td><select name="Wtype" class="cls" id="workType">
					<option value="default" disabled>None</option>
                       <option value="tier1">TIER-I</option>
                          <option value="tier2">TIER-II</option>
                        <option value="Employee">SELF EMPLOYEE</option>
                              
                        </select></td>
				</tr>
				<tr>
					<th> <label for="salary">Monthly Income</label></th>
					<td><input type="text" name="salary" PlaceHolder="ex.10000" pattern="[2-9][0-9]{4}"
					   title="Income should be Greater than 20000"class="cls" required /></td>
				</tr>
				<tr>
					<th> <label for="type"> Pan number</label></th>
					<td><input type="text" name="pan" class="cls" required /></td>
				</tr>
				 </caption>
			</table>
				
             <br><br>
			<div class="btn3">
			<button type="submit" class="btn2">Submit</button>
			<button type="reset" class="btn2">Reset</button>
			</div>
			<br>
			<br>
		</form> 
		<c:if test="${sessionScope.loan!=null}">
            <h4>${sessionScope.loan}</h4>
	    	<h4 id="transhead">Your Loan Number: ${sessionScope.loan1}</h4>
		</c:if>
		<c:remove var="loan" scope="session" />
		<c:remove var="loan1" scope="session" />
		<c:if test="${sessionScope.loanNot!=null}">
			<h4>${sessionScope.loanNot}</h4>
		</c:if>
        <c:remove var="loanNot" scope="session" />
		<c:if test="${sessionScope.Ploan!=null}">
			<h4>${sessionScope.Ploan}</h4>
		</c:if>
        <c:remove var="Ploan" scope="session" />
	</div>
 
</body>
</html>
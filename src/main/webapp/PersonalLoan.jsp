<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PERSONAL LOAN</title>
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
	height: 30%;
	margin: 0;
	color: red;
	padding: 4px;
}

nav a {
	padding-right: 79px;
}

h1 {
	color: white;
	background: #042331;
	height: 10%;
	margin: 0;
	padding: 7px;
}

a {
	text-decoration: none;
	color: white;
}

.set1 {
	padding-right: 325.5px;
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
.btn {
	float: right;
	padding: 5px 7px;
	margin-right: 5px;
	border-radius: 7px;
	color: gray;
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
#transhead{
color:green;
}
#transhead1{
color:red;}
 
</style>
</head>
<body>
		<img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
	<nav>
		 <a  href="CustomerDashBoard.jsp"> Home</a> 
                       <a  href="loans.jsp">Loans</a> 
                       <a  href="deposits.jsp">Deposits</a> 
                       <a  href="AboutUs.jsp">About us</a>
                       <a  href="ContactUs.jsp">Contact Us</a> 
                       <a   href="interest.jsp" class="set1">%</a>   
                       <a href="MyProfile.jsp">My Profile</a>
                         <button class="btn"><a href="LogoutServlet">Logout</a></button>
	</nav>
	<br>
	<br>
     <br>
	<div class="sidebar">

		<header>My Account</header>
		<ul>
			<li><a href="accountDetail.jsp">AccountDetails</a></li>
			<li><a href="TransferAmount.jsp">Transfer</a></li>
			<li><a href="Balance.jsp">Balance</a></li>
			<li><a href="FixedDeposit.jsp">Fixed Deposits</a></li>
			<li><a href="RecurringDeposit.jsp">Recurring Deposits</a></li>
			<li><a href="PersonalLoan.jsp">Personal Loan request</a></li>
			<li><a href="HousingLoan.jsp">Housing Loan request</a></li>
			<li><a href="TransactionSummary.jsp">Transaction History</a></li>
			<li><a href="depositStatusUser.jsp">Deposit Status</a></li>
			<li><a href="LoanStatusUser.jsp">Loan Status</a></li>

		</ul>
	</div>
	 
	<h2 align="center">PERSONAL LOAN</h2>
	<div class="box">
		<form action="Personal" method="post">
			<table>
			<tr>
					<th>Name</th>
					<td><input type="text"  class="cls" name="lname"
						pattern="[a-zA-z]{3,}" required /></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date"  class="cls" name="dob"
						  required /></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text"  class="cls" name="address"
						pattern="[a-zA-z0-9,-]+" required /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="email"  class="cls" name="email"
						  required /></td>
				</tr>
				<tr>
					<th>MobileNumber</th>
					<td><input type="text"  class="cls" name="mobno"
						pattern="[6-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th>  Loan Amount</th>
					<td><input type="text"  class="cls" name="amountDeposit"
						pattern="[1-9][0-9]+" required /></td>
				</tr>
				<tr>
					<th>  Tenure</th>
					<td><input type="text" name="period" pattern="[1-9]+"
						class="cls" placeholder="TENURE IN YEARS" required /></td>
				</tr>
				<tr>
					<th>  Working Type(Tier-I,Tier-II,Self Employee):</th>
					<td><input type="text" name="Wtype" class="cls" required /></td>
				</tr>
				<tr>
					<th>  Pan number</th>
					<td><input type="text" name="pan" class="cls" required /></td>
				</tr>

			</table><br><br>
			<div class="btn3">
			<button type="submit" class="btn2">Submit</button>
			<button type="reset" class="btn2">Reset</button>
			</div>
			<br>
			<br>
		</form>
		<%!String flag;
		   String acc;%>
		<%
		if (session.getAttribute("loan") != null) {
		flag = session.getAttribute("loan").toString();
		acc=session.getAttribute("loan1").toString();
		%>


		<h4 id="transhead"><%=flag%></h4>
		<h4 id="transhead">Your Loan Number: <%=acc %></h4>
		<%
		}
		else if (session.getAttribute("loanNot")!=null){%>
			
		<h4 id="transhead1"><%=session.getAttribute("loanNot") %></h4>
		<%}
		else if (session.getAttribute("Ploan")!=null){%>
		
		<h4 id="transhead1"><%=session.getAttribute("Ploan") %></h4>
		<%} %>
		<%
		session.removeAttribute("loan");
		session.removeAttribute("loanNot");
		session.removeAttribute("Ploan");
		%>
	</div>

</body>
</html>
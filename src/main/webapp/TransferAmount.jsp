<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
 
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 18px;
	color: black;
	float: left;
	background-color: rgba(9, 57, 87,.9);
	height: 25%;
	margin: 0;
	color: red;
	padding: 3px;
	 
}

nav a {
	padding-right: 47.5px;
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
	padding-right:  522px;
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

.sidebar{
position:absolute;
left:0;
width:250px;
height:96%;
background-color: rgba(9, 57, 87,.8);
color:white;
}
.sidebar header{
font-size:15px;
color:white;
text-align: center;
line-height:50px;
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
	margin-left: 130px;
}

body {
background-color: rgba(198, 208, 214,.9);
}
#transhead{
color:blue;
}
h2{
padding-left:300px;
font-size:20px;
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
</style>
</head>
<body>
<img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
        <nav>
                        <a  href="index.jsp"> Home</a> 
                       <a  href="loans.jsp">Loans</a> 
                       <a  href="deposits.jsp">Deposits</a> 
                        
                       <a  href="AboutUs.jsp">About us</a>
                       <a  href="ContactUs.jsp">Contact Us</a> 
                       
                       <a   href="interest.jsp" class="set1">%</a>   
                        <a href="MyProfile.jsp">My Profile</a>
                        <button class="btn"><a href="LogoutServlet">Logout</a></button>
       </nav>
       <br><br>
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
    <h2>Amount Transfer</h2>
 <div class="box">
 
 <form action="TransferAmount" method="post">
 
 <table>
 <tr>
 <th>Name</th>
 <td><input type="text" name="uname" class="cls" required pattern="[A-Za-z]{3,}"/></td>
 </tr>
 <tr>
 <th>Account Number</th>
 <td><input type="text" name="accno" class="cls" required pattern="[0-9]{12}"/></td>
 </tr>
 <tr>
 <th>Amount</th>
 <td><input type="text" name="amount" pattern="[1-9][0-9]+"  title="Please Enter Valid Amount" class="cls" required></td>
 </tr>
 <tr>
 <th>Pin Number</th>
 <td><input type="password" name="pin"  class="cls" required pattern="[0-9]{4}"/></td>
 </tr>
 <tr>
 <th>Receiver Account Number</th>
 <td><input type="text" name="RecAccNo" class="cls" required pattern="[0-9]{12}"/></td>
 </tr>
 </table>
 <br><br>
 <div class="btn3">
 <button type="submit" class="btn2">Submit</button>
 <button type="reset" class="btn2" >Reset</button>
 </div>
 </form>
 <br>
 <%!
String flag;
%>
<%
if(session.getAttribute("trans") != null){
flag = session.getAttribute("trans").toString();
%>
<h4 id = "transhead"><%= flag%></h4>
<% }%>
 
  <%session.removeAttribute("trans");
       %>
 </div>
</body>
</html>
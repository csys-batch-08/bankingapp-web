<%@page import="com.bankapp.model.AccountDetails"%>
<%@page import="com.bankapp.impl.AccountDetailsdaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
	padding: 3px;
}

nav a {
	padding-right: 58.2px;
	text-decoration: none;
	color: white;
}
nav a:hover{
text-decoration:none;
color:white;}

h1 {
	color: white;
	background: #042331;
	height: 8%;
	margin: 0;
	padding: 7px;
}

 

.set1 {
	padding-right: 430px;
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
padding:70px;
 margin-bottom:7px;

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
			<li><a href="LoanStatusUser.jsp">Deposit Status</a></li>
			 
		</ul>
     </div>
     <h2 align="center">Account Details</h2>
      <div class="t1">
      
 <%
long accno =  (long)session.getAttribute("useraccno");
 int pin = (int)session.getAttribute("userpin");
 AccountDetailsdaoimpl accountDetailsdaoimpl = new AccountDetailsdaoimpl();
 List<AccountDetails>  accdet = accountDetailsdaoimpl.searchDetail(accno, pin);
 %>
 <table  >
 <%for(AccountDetails acc : accdet){ %>
   <tr>
   <th>AccountType</th>
   <td><%=acc.getAccount_type() %></td>
   </tr>
   <tr>
   <th>AccountHolderName</th>
   <td><%=acc.getAccount_Holder_name() %></td>
   </tr>
   <tr>
   <th>AccountBalance</th>
   <td><%=acc.getBalance() %></td>
   </tr>
   <tr>
   <th>AccountAddress</th>
   <td><%=acc.getAddress() %></td>
   </tr>
     <th >City</th>
   <td><%=acc.getCity() %></td>
   </tr>
    <th >PinCode</th>
    <td><%=acc.getPincode() %></td>
   </tr>
    <th >DOB</th>
   <td><%=acc. getDob() %></td>
   </tr>
    <th >Mobile number</th>
   <td><%=acc. getMobile_Number()%></td>
   </tr>
    <th >Email</th>
   <td><%=acc.getEmail() %></td>
   </tr>
    <th >IFSC code</th>
   <td><%=acc.getIfsc_Code()%></td>
   </tr>
    <th >Branch Name</th>
   <td><%=acc. getBranchName() %></td>
   </tr>
   </tr>
    <th >Pan Number</th>
   <td><%=acc.getPan() %></td>
   </tr>
    
    <%} %>
    </table>
     
    <div class="btn3">
    <button type="submit" class="btn2" ><a href="CustomerDashBoard.jsp">Back</a></button>
        </div>
   </div>
   
</body>
</html>
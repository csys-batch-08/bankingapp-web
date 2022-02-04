<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="com.bankapp.model.AdminUse"%>
<%@page import="com.bankapp.impl.AdminUseDaoimpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interest</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 18px;
	 
	float: left;
	background-color: rgba(9, 57, 87,.5);
 width:100%;
	padding: 8px;
}

nav a {
	padding-right: 85.3px;
	text-decoration:none;
}
nav a:hover{
text-decoration:none;
color:white;}
nav a:hover{
text-decoration:none;
color:black;}
a {
	text-decoration: none;
	color: white;
}
.par {
	padding-left: 30px;
}
body {
	  background-image: url("images/blue.jpg") ; 
   background-repeat: no-repeat;
   background-size:  cover;
}
.table{
		 padding-bottom:10px;
	}
body{
	background-color:  rgb(247, 204, 241);
   background-repeat: no-repeat;
   background-size:  cover;
}
#image{
position: relative;
left: 145px;
}
#image img {
            width: 60%;
            height: 200px;
        }
        .prev{
            position: absolute;
            top: 150px;
            left: 10px;
            font-size: x-large;
        }
        .next{
            position: absolute;
            top: 150px;
            right: 20px;
            font-size: x-large;
        }
        .next:hover,.prev:hover{
            height: 10x;
            background-color: gray;
        }
#head{
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
  font-size:25px;
 }
</style>
</head>
<body>
	  <br><br> <h3 id="head"><i>Dharshini Bank</i></h3> <br>
	<nav>
		  <a href="index.jsp"> Home</a>
		  <a href="loans.jsp">Loans</a>
		  <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="register.jsp">Register</a>
		  <a href="login.jsp">Login</a>
		  <a href="aboutUs.jsp">About us</a>
		  <a href="contactUs.jsp" class="set1">ContactUs</a>
		  </nav><br><br><br>

	<%
	AdminUseDaoimpl admin = new AdminUseDaoimpl();
	List<AdminUse> list = admin.interestRate();
	%>
	 
	<div class="container mt-4 mb-4">
<table class="table table-striped table-dark table-hover table-sm">
	<caption> 
	 
	<%
	for (AdminUse Viewuser : list) {
	%>
	 <tbody>
 			<tr>
				<td><%=Viewuser.getCategoryType()%></td>
				<td><%=Viewuser.getDescription()%></td>
				<td><%=Viewuser.getRateOfInterest()%>%</td>
			</tr>
			<%}%>
		</tbody>
		</caption> 
	</table>
	</div>    
	 
  </body>
</html>
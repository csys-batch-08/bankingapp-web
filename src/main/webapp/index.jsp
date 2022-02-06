<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
			<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>


<title>Index Page </title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 17px;
 	float: left;
	background-color: rgba(9, 57, 87,.5);
	padding: 8px;
	width:100%;
}
nav a {
	padding-right: 67px;
	text-decoration:none;
	color:white;
}
nav a:hover{
color:white;
text-decoration:none;}
h2 {
	color: white;
	 background-color: rgba(9, 41, 63,0.9);
	height: 10%;
	margin: 0;
	padding: 7px;
}

a {
	text-decoration: none;
	color: white;
	 
}

.par {
	padding-left: 30px;
}

marquee {
	height: 200px;
	color: red;
}

.img {
	padding-left: 200px;
}

.set1 {
	padding-right:  350.4px;
}

h4 {
	padding-left: 50px;
	color:green;
	
}

li, p {
	padding-left: 50px;
	padding-right:100px;
	color:white;
	list-style:none;
	font-size:19px;
}

.t1 {
	display: inline-flex;
}
 
 body{
  background-image: url("images/bnk.jpg") ; 
   background-repeat: no-repeat;
   background-size:  cover;
 
 }
 .butn {
 padding-left: 550px;
 }
 .buttn{
   background-color:  rgba(100, 201, 231,.5);
    color:white;
    border:0px;
    border-radius:6px;
    padding: 10px 25px;
    text-align : center;
 }
 .buttn a:hover{
 color:blue;}
 #head{
  font-family:  Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
 }
</style>
</head>
<body>

	 <br> <h3 id="head"><em>Dharshini Bank</em></h3> <br>
	 <nav>
		  <fmt:bundle basename = "com.bankapp.bundle.NavBar" prefix="nav.">
		 <a href="index.jsp"><fmt:message  key="Home"/></a>
		  <a href="loans.jsp"><fmt:message  key="Loans"/></a>
		  <a href="deposits.jsp"><fmt:message  key="Deposits"/> </a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="register.jsp"><fmt:message key="Register"/></a>
		  <a href="login.jsp"><fmt:message  key="Login"/> </a>
		  <a href="aboutUs.jsp"><fmt:message  key="AboutUs"/></a>
		  <a href="contactUs.jsp"  ><fmt:message  key="ContactUS"/></a>
	 </fmt:bundle>
		   
	 
	</nav><br><br>

 <h4>Vision:</h4>
		<br>
		<p>Delivering excellence in financial services through customer
			focus, employee engagement<br> and sustainable growth.</p>
		  
		<div class="t1">
			<div class="t2">
				<h4>Mission:</h4>
				 
				<ul> 
				<li>Bring the best of innovation and technology in our
					offerings</li>
					 
				
				<li>Be responsive to the unique needs of every customer through
					all channels of choice</li>
				  
				<li>To provide value to stake- holders</li>
				 
				<li>Empower and engage our employees</li>
				 

				</ul>
			</div>
		
			 
		</div>
		<div class="butn">
	 <a href="login.jsp"><button type="submit" class="buttn" >WELCOME </button></a>
</div>
</body>
</html>

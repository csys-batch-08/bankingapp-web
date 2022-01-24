<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>


<title>index</title>
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
	color: black;
	float: left;
	background-color: rgba(9, 57, 87,.5);
	height: 25%;
	margin: 0;
	color: red;
	padding: 8px;
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
</style>
</head>
<body>


	 <img src="images/boilogo.png" alt="couldnot load" width="400" height="100" />
	 <nav>
		  <a href="index.jsp"> Home</a>
		  <a href="loans.jsp">Loans</a>
		  <a href="deposits.jsp">Deposits</a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="Reg.jsp">Register</a>
		  <a href="login.jsp">Login</a>
		  <a href="AboutUs.jsp">About us</a>
		  <a href="ContactUs.jsp" class="set1">ContactUs</a>
		   
	 
	</nav><br><br>

 <%-- <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/deposit.jpg"  class="d-block w-100" alt="couldn'tLoad" Style="width:50%!important ">
    </div>
    <div class="carousel-item">
      <img src="images/deposit1.jpg"  class="d-block w-100" alt="couldn'tLoad" Style="width:50%!important ">
    </div>
    <div class="carousel-item">
      <img src="images/deposit2.jpg"    class="d-block w-100" alt="couldn'tLoad" Style="width:50%!important">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev" Style="width:50%!important">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next" Style="width:50%!important">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button> 
  </div> --%>
 
	 

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
				<br>
				<li>Be responsive to the unique needs of every customer through
					all channels of choice</li>
				 <br>
				<li>To provide value to stakeholders</li>
				<br>
				<li>Empower and engage our employees</li>
				<br>

				</ul>
			</div>
		
			 
		</div>
		<div class="butn">
	 <button type="submit" class="buttn" ><a href="login.jsp">WELCOME</a></button>
</div>
</body>
</html>

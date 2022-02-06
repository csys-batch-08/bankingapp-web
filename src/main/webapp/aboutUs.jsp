<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	}
.section1 {
	width: 100%;
}
.container {
	width: 80%;
	display: block;
	margin: auto;
	padding-top: 30px;
	background-color: rgba(247, 204, 241, .5);
}
.content-section {
	float: left;
	width: 55%;
}
.img1 {
	height: 465px;
	padding-left: 15px;
}
.image-section img {
	width: 450px;;
	height: 520px;
	background-color: rgba(247, 204, 241, .5);
}
.content-section.title {
	text-transform: uppercase;
	font-size: 28px;
}
.content-section.content h3 {
	margin-top: 20px;
	color: #5d5d5d;
	font-size: 19px;
}
.content-section.content p {
	margin-top: 10px;
	color: #5d5d5d;
	font-family: Garamond, serif;
	font-size: 18px;
	line-height: 1.5;
	text-align: justify;
}
.content-section .content .button {
	margin-top: 30px;
	margin-left: 60px;
}
.btn2 {
	padding-left: 40px;
}
button {
	background-color: #2E94E4;
	padding: 6px 15px;
	text-decoration: transparent;
	color: #fff;
	font-size: 15px;
	letter-spacing: 1.5px;
}
button a {
	color: #fff;
}
.content {
	text-align: justify;
	padding-right: 20px;
	font-family: Garamond, serif;
}
nav {
	font-size: 17px;
 	float: left;
	background-color: rgba(9, 57, 87,.5);
	padding: 8px;
}
nav a {
	padding-right: 73.9px;
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
.par {
	padding-left: 30px;
}
marquee {
	height: 200px;
	color: red;
}
.set1 {
	padding-right: 276.5px;
}
p {
	padding-right: 30px;
	font-size: 18px;
	padding-left: 30px;
}
h3, h4 {
	padding-left: 15px;
}
body {
	background-image: url("images/bankof5.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
#more {
	display: none;
	background-color: pink;
}
#image {
	position: auto;
	left: 145px;
	padding-left: 450px;
	padding-top: 40px;;
}
#image img {
	width: 70%;
	height: 400px;
}
.prev {
	position: absolute;
	top: 150px;
	left: 10px;
	font-size: x-large;
}
.next {
	position: absolute;
	top: 150px;
	right: 20px;
	font-size: x-large;
}
.next:hover, .prev:hover {
	height: 10x;
	background-color: gray;
}
h2{
text-align:center;}
#head{
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  margin-left:20px;
  color:rgba(243, 31, 119, 0.7);
  font-size:25px;
 }
 
</style>
</head>
<body>

	 <br> <br> <h3 id="head"><em>Dharshini Bank</em></h3> <br>
	<nav>
	<fmt:bundle basename = "com.bankapp.bundle.NavBar" prefix="nav.">
		 <a href="index.jsp"><fmt:message  key="Home"/></a>
		  <a href="loans.jsp"><fmt:message  key="Loans"/></a>
		  <a href="deposits.jsp"><fmt:message  key="Deposits"/> </a> 
		  <a href="interest.jsp" >Interest Rate</a>
		  <a href="register.jsp"><fmt:message key="Register"/></a>
		  <a href="login.jsp"><fmt:message  key="Login"/> </a>
		  <a href="aboutUs.jsp"><fmt:message  key="AboutUs"/></a>
		  <a href="contactUs.jsp" class="set1"><fmt:message  key="ContactUS "/></a>
	 </fmt:bundle>
	</nav>
	<br><br><br><br>
	<h1></h1>
	<h2 >ABOUT US</h2><br>
	<div class="section1">
		<div class="container">
			<div class="content-section">
				<div class="content">
					<p>Bank of India was founded on 7th September, 1906 by a group
						of eminent businessmen from Mumbai. The Bank was under private
						ownership and control till July 1969 when it was nationalised
						along with 13 other banks.</p><br>
					<p>Beginning with one office in Mumbai, with a paid-up capital
						of Rs.50 lakh and 50 employees, the Bank has made a rapid growth
						over the years and blossomed into a mighty institution with a
						strong national presence and sizable international operations. In
						business volume, the Bank occupies a premier position among the
						nationalised banks.</p><br>					
					<p>The Bank has over 5000 branches in India spread over all
						states/ union territories including specialized branches. These
						branches are controlled through 59 Zonal Offices and 10 NBG
						Offices. There are 45 branches/ offices abroad which includes 23
						own branches, 1 representative office and 4 Subsidaries(20
						branches) and 1 joint venture.</p><br>
					<p>The Bank came out with its maiden public issue in 1997 and
						follow on Qualified Institutions Placement in February 2008.</p>
					</div>
				<div class="btn2">
					<a href="ContactUs.jsp" target="_self"><button type="submit"name="submit" >Contact Us</button></a>
	    		</div>
	</div>
			<div class="img1">
				<div class="image-section">
					<div id="image">
						<div class="slideshow-container">
							<div class="mySlides fade">
								<img src="images/bankof7.jpg"  Style="width:60%;  height:60%;" alt="Couldn't load image">
							</div>
							<div class="mySlides fade">
								<img src="images/bankof6.jpg"  Style="width:60%;  height:60%;" alt="Couldn't load image">
							</div>
							<div class="mySlides fade">
								<img src="images/bankof2.jpg"  Style="width:60%;  height:60%;" alt="Couldn't load image">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	var slideIndex = 0;
	showSlides();
	function showSlides() {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		slideIndex++;
		if (slideIndex > slides.length) {
			slideIndex = 1
		}
		slides[slideIndex - 1].style.display = "block";
		setTimeout(showSlides, 2500); // Change image every 2 seconds
	}
</script>
</html>
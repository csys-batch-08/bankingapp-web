<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: sans-serif;
}

nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87, .7);
	height: 25%;
	width:100%;
	padding: 8px;
}

nav a {
	padding-right: 73.7px;
}

nav a:hover {
	text-decoration: none;
	color: black;
}

a {
	text-decoration: none;
	color: white;
}

.par {
	padding-left: 30px;
}

.set1 {
	padding-right: 293.4px;
}

p {
	color: white;
}

.set2 {
	text-align: center;
	font-size: 20px;
}

body {
	background-image: url("images/bankof5.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.content-section {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.contact-info {
	color: #fff;
	max-width: 500px;
	line-height: 65px;
	padding-left: 50px;
	font-size: 18px;
}

.contact-info i {
	margin-right: 20px;
	font-size: 25px;
}

.contact-form {
	max-width: 700px;
	margin-right: 50px;
	padding-left: 155px;
}

.contact-info, .contact-form {
	flex: 1;
}

.contact-form h2 {
	color: #fff;
	text-align: center;
	font-size: 35px;
	text-transform: uppercase;
	margin-bottom: 30px;
}

.contact-form .text-box {
	background: #000;
	color: #fff;
	border: none;
	height: 50px;
	padding: 12px;
	font-size: 15px;
	border-radius: 5px;
	opacity: 0.9;
	margin-bottom: 20px;
}

.contact-form .text-box:first-child {
	margin-right: 15px;
}

.contact-form textarea {
	background: #000;
	color: #fff;
	border: none;
	width: 100%;
	padding: 12px;
	font-size: 15px;
	border-radius: 5px;
	margin-bottom: 20px;
	opacity: 0.9;
}

.contact-form .s-btn {
	float: right;
	background-color: #2E94E4;
	color: #fff;
	border: none;
	width: 120px;
	height: 40px;
	font-size: 15px;
	border-radius: 5px;
	text-align: center;
}

.sec {
	display: inline-flex;
	padding-left: 5px;
}

#transhead {
	color: green;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 25px;
}
</style>
</head>
<body>

	<br>
	<br>
	<h3 id="head">
		<em>Dharshini Bank</em>
	</h3>
	<br>
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
	</nav>
	<br>
	<br>
	<br>
	<div class="sec">
		<div class="contact-section">
			<div class="contact-info">
				<div>
					<em class="fas fa-map-marker-alt"></em>Address
				</div>
				<div>
					<em class="fas fa-envelope"></em> dharshiniBank@dharshinibank.in
				</div>
				<div>
					<em class="fas fa-phone"></em>+91 9652220020
				</div>
				<div>
					<em class="fas fa-clock"></em>8:00 AM to 8:00 PM
				</div>
				<div>
					<em class="fas fa-clock"></em>Post 8 PM till 8 AM only critical
					service offered
				</div>
			</div>
		</div>
		<br>
		<div class="contact-form">
			<h2 class="set2">Contact Us</h2>
			<br> <br>
			<form class="contact" action="ContactUs" method="post">
				<input type="text" name="name" id="name" class="text-box"
					placeholder="Your Name" required> <input type="email"
					class="text-box" name="email" id="email" placeholder="Your Email" required>
				<textarea name="message"  id="message"rows="6" placeholder="Your Message"
					required></textarea>
				<button type="submit" name="submit" class="s-btn" >SUBMIT </button>
			</form>
		</div>
	</div>
	 <c:if test="${sessionScope.msg!=null}">
          <h4 id="depohead">${sessionScope.msg}</h4>
          </c:if> 
          <c:remove var="msg" scope="session"/>
</body>
</html>
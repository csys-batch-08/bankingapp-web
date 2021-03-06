<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Interest Rate</title>
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
	font-size: 18px;
	float: left;
	background-color: rgba(9, 57, 87, .5);
	width: 100%;
	padding: 8px;
}

nav a {
	padding-right: 85.3px;
	text-decoration: none;
}

nav a:hover {
	text-decoration: none;
	color: white;
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

body {
	background-image: url("images/blue.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.table {
	padding-bottom: 10px;
}

body {
	background-color: rgb(247, 204, 241);
	background-repeat: no-repeat;
	background-size: cover;
}

#image {
	position: relative;
	left: 145px;
}

#image img {
	width: 60%;
	height: 200px;
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
		  <a href="RateOfInterest">Interest Rate</a>
		  <a href="register.jsp"><fmt:message key="Register"/></a>
		  <a href="login.jsp"><fmt:message  key="Login"/> </a>
		  <a href="aboutUs.jsp"><fmt:message  key="AboutUs"/></a>
		  <a href="contactUs.jsp"><fmt:message  key="ContactUS"/></a>
	 </fmt:bundle>
	</nav>
	<br>
	<br>
	<br>

	

	<div class="container mt-4 mb-4">
		<table class="table table-striped table-dark table-hover table-sm">
			<caption>
				<thead>
					<th>Type </th>
					<th>Description </th>
					<th>Rate of Interest</th>
				</thead>
				
				<tbody>
				 <c:forEach items="${rateInterest}" var="interestrate">
		
					<tr>
						<td>${interestrate.categoryType}</td>
						<td>${interestrate.description}</td>
						<td>${interestrate.rateOfInterest}%</td>
					</tr>
					 </c:forEach>
				</tbody>
			</caption>
		</table>
	</div>

</body>
</html>
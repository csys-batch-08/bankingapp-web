<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 17px;
	width: 98.7%; 
	background-color : rgba( 9, 57, 87, .5);
	height: 25%;
	padding: 8px;
	background-color: rgba(9, 57, 87, .5);
}

nav a {
	padding-right: 90px;
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
	font-size:21px;
}
 
p {
	margin-left: 150px;
	text-align: justify;
	padding-right: 90px;
}

li {
	margin-left: 150px;
	text-align: justify;
	padding-right: 70px;
}

.h4 {
	margin-left: 90px;
	color: green;
	padding-right: 50px;
}

.h1 {
	color: steelblue;
}

.btngrp {
	padding: 5px 7px;
	border-radius: 7px;
	color: black;
	background-color: yellowgreen;
}

button {
	background-color: transparent;
	border-color: transparent;
	text-decoration: none;
	text-align: center;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 25px;
}

.cls1 {
	text-align: center;
}
h2{
text-align:center;
}
</style>
</head>
<body>

 
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
		  <a href="contactUs.jsp" ><fmt:message  key="ContactUS"/></a>
	 </fmt:bundle>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<h2 class="cls1">Personal Loan Starting at 10.00%</h2>
	<br>
	<h3 class="cls1">Apply for an online personal loan at low
		interest rates and get instant approval.</h3>
	<br>
	<br>
	<h4 class="cls1">
		Login to CHECK AVALIABLITY of Loans
		<button type="submit" class="btngrp">LOG IN</button>
	</h4>

	<br>
	<br>
	<h4 class="h4">Personal Loan</h4>
	<br>
	<ul>
		<li>Current lowest personal loan interest rates start from 10.00%
			p.a.</li>

		<li>Compare 100+ personal loan banks at MyMoneyMantra and choose
			the best one.</li>

		<li>Check fees  and charges of all top banks offering personal loans
			in India.</li>

		<li>Get flexible tenure of 12 to 60 months to repay the loan.</li>

		<li>Submit online loan application and get instant loan approval</li>

		<li>Personal Loan amount can be used for any personal purpose,
			including marriage, education, medical emergency, shopping, travel,
			etc.</li>

		<li>No collateral or security required as personal loans are
			unsecured loans.</li>

		<li>You can get a personal loan through the best instant loan app
			in India or through online lending marketplaces.</li>

	</ul>
	<br>
	<br>
	<h3 class="h4">Features And Benefits of Personal Loan</h3>
	<br>
	<ul>
	<li><strong>The rate of Interest:</strong> The Rate of Interest on Personal
		Loans/ Annual Percentage Rate (APR) is between 9.6%-24% depending on
		your credit score, income and so forth.</li>
	 
	<li><strong>Loan amount:</strong> You can get a loan online for as low as
		10,000 and as high as 50 lakhs depending on your requirement and
		eligibility.</li>
	 
	<li><strong>Loan tenure:</strong> Personal loans are available for periods
		as short as 12 months. The average tenure for a Personal Loan is
		between 12 and 60 months,depending on the loan amount.</li>
 
	<li><strong>Security: </strong>Due to its unsecured nature, collateral is
		not required.</li>
	 
	<li><strong>Loan turn around time: </strong>A Personal Loan typically has the
		fastest turn around time in the industry. Many banks personal loans
		online approval within 48 hours after submission of the online
		application.</li>
 
	<li><strong>Processing fees: </strong>It depends on the individual bank. It
		usually ranges between 500 to - 2.5% of the loan amount.</li>
	 
	<li><strong>Pre payment penalty: </strong>Banks charge pre payment penalty if
		you repay your Personal Loan before the determined period. The charges
		range between 1-2% of the outstanding amount on the date of closure</li>
   </ul>
	<br>
	<br>
	<br>
	<h2  >Housing Loan</h2>
	<br>
	<p>Housing Loan is a stepping stone in realizing your dream home.
		LIC HFL offers wide variety of home loans which will fulfill your
		needs at one of the lowest interest rates available. Our home loans
		cater to all types of customer base viz., salaried, self-employed,
		professional, NRIs, etc. Our products are customizable according to
		your home loan eligibility.</p>
	<br>


	<h3 class="h4">Online Home Loans</h3>
	<br>
	<p>
		Login to Apply for Home Loan online.<a href="login.jsp">Click here</a>
	</p>
	<br>

	<h3 class="h4">LIC HFL Home Loan Features</h3>
	<br>
	<ul>
		<li>Online Home loan sanction facility</li>
		 
		<li>Quick sanction and low EMI</li>
		 
		<li>Simple documentation</li>
		 
		<li>Maximum Tenure of 30 years or attainment of 60 years
			whichever is earlier</li>
	 
		<li>Amongst the lowest rate of interest</li>
		 
		<li>No Pre-Payment penalty</li>
		 
		<li>Available for construction / purchase of house or flat from
			private developer or housing boards and repairs/renovation to the
			existing properties</li>
		 
		<li>Take over or balance transfer of existing Home Loans possible</li>
	 </ul>
</body>
</html>
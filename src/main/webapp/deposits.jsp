<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Details</title>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87, .5);
	padding: 8px;
	width:100%;
}

nav a {
	padding-right: 80.3px;
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
	padding-right: 279px;
}

.set2 {
	text-align: center;
}

p {
	padding-left: 150px;
	padding-right: 150px;
	font-size: 20px;
	text-align: justify;
}

body {
	background-image: url("images/blue.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 25px;
}

h2 {
text-align:center;
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
	<h2 >Fixed Deposits (FDs): How they work</h2>
	<br>
	<br>
	<p>Fixed Deposits have been a tried-and-tested savings method for a
		long time. Almost all banks in India have Fixed Deposits schemes
		available for their customers. You can read more about the rules and
		processes of obtaining FDs here. While FDs have been the conventional
		investment tools, you need to keep some things in mind before going
		for one:</p>
	<br>
	<br>
	<h3 class="set2">Spread your investments</h3>
	<br>
	<br>
	<p>If you want to invest in an FD, do not park all your investments
		in a single bank. You need to know that bank FDs aren't as secure as
		you think. In case of bank default, you will be eligible for a maximum
		compensation of Rs 5 lakh from Deposit Insurance and Credit Guarantee
		Corporation (DICGC) with effect from 4 February 2020. This happens
		even though you held deposits of amount higher than Rs 1 lakh. If you
		have Rs 5 Lakh to invest, then hold FDs of Rs 1 lakh in five banks
		rather than Rs 5 lakh in a single bank.</p>
	<br>
	<br>
	<h3 class="set2">Premature withdrawals attracts penalty</h3>
	<br>
	<br>
	<p>You need to know that FD involves a lock-in period equal to
		duration of the investment. Before going for an FD, review your income
		needs for the horizon. If you institute an FD for a 5-year term, then
		the bank won't allow for withdrawals before completion of 5 years. In
		case you need your money before maturity, bank will impose a penalty.
		If the penalty is 1%, then you may lose more than you earned during
		the tenure. Thus, it's advisable not to break your FDs before
		maturity.</p>
	<br>
	<br>
	<h3 class="set2">Interest earned is clubbed in your income</h3>
	<br>
	<br>
	<p>FDs aren't as tax-efficient as mutual funds and equities. The
		interest earned on FDs will be clubbed in your total income and taxed
		as per your income slab. Suppose you create an FD in the name of your
		spouse. The money deployed to create FD won't attract tax but the
		interest earned will form part of your income and be taxed.
		Equity-Linked Saving Scheme (ELSS) can be a tax-efficient way to
		invest and grow wealth. It has the shortest lock-in period. Moreover,
		it offers higher returns than FD.</p>
	<br>
	<br>
	<h2 >Recurring Deposits (RDs): Are they for you?</h2>
	<br>
	<br>
	<p>RD or Recurring Deposits are an investment tool which allows
		investors to make regular monthly payments and save money for the long
		term. Investors can choose the tenure of the deposit and the minimum
		monthly payment they wish to make according to their convenience. RD
		schemes are generally more flexible than FD schemes and are generally
		preferred by those who want to start an account for the purpose of
		saving money and building a rainy-day fund. Here are some things you
		should keep in mind while opting for a Recurring Deposit:</p>
	<br>
	<br>
	<h3 class="set2">Use RDs for short-term goals</h3>
	<br>
	<br>
	<p>Recurring deposits are the ideal products to opt for when
		planning short-term goals you wish to realize in the next 1-3 years.
		These may include saving up for a down payment of your new home, paying
		for your children's education, renovating your home, saving up for a
		degree abroad and so on.</p>
	<br>
	<br>
	<h3 class="set2">Be aware of the rules and penalties</h3>
	<br>
	<br>
	<p>Recurring deposits are very easy to open. Most banks in the
		country have this facility. But, they do come with some hidden
		charges. For instance, if you were to withdraw the amount in the RD
		account before the tenure finishes, you may have to pay certain
		charges. It is important to know these rules before you start an RD
		account so you can be better prepared for the future. Apart from
		these, there are other types of accounts in which you can deposit your
		money:</p>
	<br>
	<br>
</body>
</html>
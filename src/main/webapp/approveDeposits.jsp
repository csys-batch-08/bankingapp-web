<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Approve Deposits</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	font-size: 17px;
	float: left;
	background-color: rgba(9, 57, 87, .9);
	padding: 7.4px;
	width: 100%;
}

nav a {
	padding-right: 95px;
}

nav a:hover {
	text-decoration: none;
	color: black;
}

a {
	text-decoration: none;
	color: white;
}

.set1 {
	padding-right: 450px;
}

.btn {
	color: white;
	background-color: transparent;
	border-color: transparent;
	font-size: 15px;
	float: right;
}

.sidebar {
	position: absolute;
	left: 0;
	width: 250px;
	height: 100%;
	background-color: rgba(9, 57, 87, .8);
	color: white;
}

.sidebar header {
	font-size: 15px;
	color: white;
	text-align: center;
	line-height: 50px;
	background-color: rgba(9, 57, 87, .3);
}

ul {
	list-style-type: none;
}

.sidebar ul a {
	height: 100%;
	width: 100%;
	line-height: 40px;
	font-size: 14px;
	padding-left: 40px;
	color: white;
}

ul li:hover a {
	padding-left: 50px;
}

.sidebar ul a {
	margin-right: 16px;
}

.box {
	width: 380px;
	height: 700px;
	position: relative;
	margin: 6% auto;
	background: transparent;
	padding: 5px;
	box: shadow;
}

.btn2 {
	padding: 5px 15px;
	background-color: green;
	color: white;
	border: 0;
	border-radius: 3px;
}

.btn3 {
	margin-left: 670px;
}

.btn2 a:hover {
	text-decoration: none;
	color: white;
}

body {
	background-color: rgb(198, 208, 214);
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

.table {
	margin-top: 30px;
	width: 1000px;
	margin-left: 200px;
	   padding:5px;
}

.table th {
	background-color: rgba(161, 15, 95, .5);
 
}

.table td {
	background-color: rgba(35, 106, 240, .5);
}

.div1 {
	padding-left: 460px;
}

#transhead {
	color: red;
	font-size: 20px;
	margin-left: 250px;
}

.head2 {
	margin-left: 270px;
	font-size: 18px;
}

#thead1 {
	padding: 1px;
}

#head {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	color: rgba(243, 31, 119, 0.7);
	font-size: 23px;
}
</style>
</head>
<body>
	<br />
	<h3 id="head">
		<em> Dharshini Bank</em>
	</h3>
	<br />
	<nav>
		<fmt:bundle basename="com.bankapp.bundle.NavBar" prefix="nav.">
			<a href="adminDashBoard.jsp"><fmt:message key="Home" /></a>
			<a href="loans.jsp"><fmt:message key="Loans" /></a>
			<a href="deposits.jsp"><fmt:message key="Deposits" /> </a>
			<a href="RateOfInterest">Interest Rate</a>
			<a href="aboutUs.jsp"><fmt:message key="AboutUs" /></a>
			<a href="contactUs.jsp"><fmt:message key="ContactUS" /></a>
			<a href="LogoutServlet"><button class="btn">
					<fmt:message key="Logout" />
				</button></a>

		</fmt:bundle>
	</nav>
	<br />
	<br />
	<div class="sidebar">
		<header>My Account</header>
		<ul>
			<li><a href="ApproveLoans">Approve Loans</a></li>
			<li><a href="ApproveDeposit">Approve Deposits</a></li>
			<li><a href="InterestRate">Rate Of Interest</a></li>
			<li><a href="ViewAllUser">View All Users</a></li>
			<li><a href="ViewAllAccount">View All Account</a></li>
			<li><a href="transactionByDate.jsp">Transaction by Date</a></li>
			<li><a href="transactionByAccount.jsp">Transaction by
					Account</a></li>
			<li><a href="adminAddAccount.jsp">Insert Account Details </a></li>
			<li><a href="updateAccountDetails.jsp">Update Account
					Details </a></li>
			<li><a href="userCancel.jsp">Cancel Account</a></li>
		</ul>
	</div>
	<h2 class="head2">Deposit Approval</h2>
	<div class="container mt-4 mb-4">
		<table class="table table-hover table-striped">
			<caption>
				<thead>
					<tr>
						<th id="thead1">S.no</th>
						<th id="thead1">Deposit Number</th>
						<th id="thead1">Account Number</th>
						<th id="thead1">Deposit Type</th>
						<th id="thead1">Amount</th>
						<th id="thead1">AppliedDate  </th>
						<th id="thead1">Tenure</th>
						<th id="thead1">Status</th>
						<th id="thead1">Approve</th>
						<th id="thead1">Reject</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ApproveDeposit}" var="approvedeposit">
						<c:set var="i" value="${i+1 }" />
						<c:set var="approved" value="Approved" scope="page" />
						<c:set var="rejected" value="Rejected" scope="page" />
						<tr>
							<td>${i}</td>
							<td>${approvedeposit.depositNumber}</td>
							<td>${approvedeposit.accno }</td>
							<td>${approvedeposit.depositType }</td>
							<td>${approvedeposit. amount}</td>
							<fmt:parseDate value="${approvedeposit.dateOfDeposit}"
								pattern="yyyy-MM-dd" var="maturedDate" type="date" />
							<td><fmt:formatDate value="${maturedDate}"
									pattern="dd-MM-yyyy" /></td>
							<td>${approvedeposit.tenure }</td>
							<td>${approvedeposit.depositStatus}</td>
							<c:choose>
							<c:when test="${approvedeposit.depositStatus.equals('NotApproved')}">
							<td><a
								href="DepositApproveAdmin?accno=${approvedeposit.depositNumber}&status=${approved}">Approve
							</a></td>
							<td><a
								href="DepositApproveAdmin?accno=${approvedeposit.depositNumber}&status=${rejected}">Reject
							</a></td>
                            </c:when>
                            <c:otherwise>
							<td>Status Updated Already</td>
							<td>Status Updated Already</td> 
							</c:otherwise>
                            </c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</caption>
		</table>
		<br>
		<c:if test="${sessionScope.admin!=null}">
			<h4 id="transhead">${sessionScope.admin}</h4>
		</c:if>
		<c:remove var="admin" scope="session" />
	</div>

</body>
</html>
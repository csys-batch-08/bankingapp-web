<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
 
<title>User Login</title>
<style>
.box {
	width: 380px;
	height: 380px;
	position: relative;
	margin: 6% auto;
	background: transparent;
	padding: 20px;
	box: shadow;
	background-image: url("images/bank2.jpg");
	background-repeat: no-repeat;
}

.textfield {
	text-align: center;
	border-radius: 15px;
	background: transparent;
	padding: 10px 10px 10px 10px;
	margin-left: 100px;
	color: black;
}

.lab {
	margin-left: 100px;
	color: white;
}

.btn1 {
	border-radius: 10px;
	padding: 10px 20px;
	margin-left: 85px;
	background-color: transparent;
	color: white;
}

p {
	color: white;
}

.btn1:hover {
	color: white;
}

h2 {
	color: black;
}

body {
	background-image: url("images/bank10.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

a {
	color: white;
	text-decoration:none;
}

h2 {
	text-align: center;
}
</style>

</head>
<body>
	<div class="img">
		<div class="box">
			<form action="login" method="post">
               <h1></h1>
				<h2>Login </h2>
				<label for="userId" class="lab">EMAIL ID</label><br>
				 <input 	type="text" class="textfield" name="userId" id="userId"
					pattern="[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}"
					placeholder="EMAIL ID" required>
					<br> <br> 
				 <label for="pwd" class="lab">PASSWORD </label>
				 <input type="password" name="pwd" class="textfield" id="pwd" pattern="[A-Za-z0-9]{8,10}"
					placeholder="PASSWORD" required><br> <br>
				  <a href="register.jsp"> Don't have an account? Please Register! </a> <br>
				<br>
				<button type="submit" class="btn1">Log In</button>
				<a href="index.jsp"><button type="submit" class="btn1">Back </button></a>
				
				<a href="forgotPassword.jsp">ForgotPassword?</a>


				<c:if test="${sessionScope.login!=null}">
					<h4>${sessionScope.login}</h4>
				</c:if>

				<c:remove var="login" scope="session" />

			</form>


		</div>

	</div>
</body>
</html>
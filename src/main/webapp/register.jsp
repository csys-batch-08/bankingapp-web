<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<style>
.box{
        width:400px;
        height:405px;
        position:relative;
        margin:6% auto; 
        background: transparent;
        padding:0px 0px 5px 10px;
        box:shadow;
        background-image: url("images/bank2.jpg") ;
        background-repeat: no-repeat;
        }
        
.textfield{
     text-align: center;
     border-radius: 7px;
      background :transparent;
     padding : 10px 10px 10px 10px;
     margin-left: 100px;
     color:black;
 }
 .lab
 {
    margin-left: 100px;
    color:white;
 }
 .btn1{
     border-radius: 10px;
     padding : 5px 10px ;
     margin-left:50px;
     background-color:  transparent;
     color:white ;
 }
 p{
     color:white;
 }
 .btn1:hover {
     color:white;
 }
h2{
    color : black ;
}
body{
        background-image: url("images/bank10.jpg") ;
        background-repeat: no-repeat;
        background-size:cover;
}
#transhead{
color:red;
font-size:20px;
}
</style>
<script>
	function myfunction() {
		var pswd = document.getElementById("pwd");
		var cpswd = document.getElementById("Cpwd");
		if (pswd != cpswd) {
			document.getElementById("pwd").style.borderColor = "#E34234";
			document.getElementById("Cpwd").style.borderColor = "#E34234";
		}
	}
</script>
</head>

<body>
<div class="box">   
<h3>USER</h3>
 <form  action="register" method="post"  >
          <label for="Name" class="lab">Name</label> <br>
                <input type="text"  class="textfield" name="uname" id="uname" pattern="[A-Za-z]{5,}" placeholder="Name"required  > <br>
 
                  <label for="email" class="lab">Email</label> <br>
                 <input type="email"  class="textfield" name="emailId" id="emailId" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" placeholder="Email" required >  <br>
 
               <label for="pwd" class="lab">Create Password:</label> <br>
               <input type="Password"  class="textfield" name="pwd" id="pwd" pattern="[A-Za-z0-9]{8,10}" placeholder="Password" 
               title="(Minimum 8 characters includes lowercase,uppercase,numbers)" required  ><br> 
 
               <label for="confirmPwd" class="lab" >Confirm Password:</label> <br>
               <input type="Password"  class="textfield" name="Cpwd" id="Cpwd" required  placeholder="Confirm Password">  <br>
 
                <label for="mobNo" class="lab" >Mobile Number</label> <br>
                <input type="text"   class="textfield" name="mobNo" id="mobno" pattern="[6-9][0-9]{9}" required placeholder="MobileNumber" > <br><br>
              
            
             <button type="submit" class="btn1"  onclick="myfunction()">Submit</button>
              <button type="reset" class="btn1" >Reset</button>
              <a href="index.jsp"><button type="submit" class="btn1" >Back</button></a>
               
     
</form>
<c:if test="${sessionScope.reg!=null}">
           <h4>${sessionScope.reg}</h4>
          </c:if> 
           <c:remove var="reg" scope="session"/>
 
</div>
</body>

</html>
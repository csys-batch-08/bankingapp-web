<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="RegCss.css">
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
}
</style>
</head>
<script>
        
        function validate(){
        	var pwd=document.getElementbyId("pwd") ;
            var Cpwd=document.getElementbyId("Cpwd") ;
        	if(pwd!=Cpwd){
        		document.getElementById("pwd").style.borderColor = '#E34234';
                document.getElementById("Cpwd").style.borderColor = '#E34234';
        	}
        	 
        }
</script>
<body>
<div class="box">   
<h3>USER</h3>
 <form  action="register" method="post" >
          <label for="Name" class="lab">Name</label> <br>
                <input type=" text"  class="textfield" name="uname" pattern="[A-Za-z]{5,}" placeholder="Name"required  > <br>
 
                  <label for="email" class="lab">Email</label> <br>
                 <input type="email"  class="textfield" name="emailId" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" placeholder="Email" required >  <br>
 
               <label for="pwd" class="lab">Create Password:</label> <br>
               <input type="Password"  class="textfield" name="pwd" id="pwd" pattern="[A-Za-z0-9]{8,10}" placeholder="Password" required  ><br> 
 
               <label for="confirmPwd" class="lab" >Confirm Password:</label> <br>
               <input type="Password"  class="textfield" name="confirmPwd" id="Cpwd" required  placeholder="Confirm Password">  <br>
 
                <label for="mobNo" class="lab" >Mobile Number</label> <br>
                <input type="phone"   class="textfield" name="mobNo"  pattern="[6-9][0-9]{9}" required placeholder="MobileNumber" > <br><br>
              
            
              <button type="submit" class="btn1" onclick="validate()">Submit</a></button>
              <button type="reset" class="btn1" >Reset</button>
              <button type="submit" class="btn1" ><a href="index.jsp">Back</a></button>
               
     
</form>

<%
String flag;
%>
<%
if(session.getAttribute("reg") != null){
flag = session.getAttribute("reg").toString();
%>
<h4 id = "transhead"><%= flag%></h4>
<% }%>
 
  <%session.removeAttribute("reg");
       %>
</div>

 </body>
</body>
</html>
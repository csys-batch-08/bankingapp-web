<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="RegCss.css">
<style>
*{
margin:0;
padding:0;
}
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
     padding : 10px 20px ;
     margin-left:85px;
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
<title>Login</title>
</head>
<body>
<div class="img">
  <div class="box">
    <form action="ForgotPassword"  method="post">
         
        <h2 >FORGOT PASSWORD</h2><br>
        
        <label for="userid" class="lab">EMAIL ID</label><br>
                  <input type="text" class="textfield" name="userId" pattern="[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}" placeholder="EMAIL ID"  ><br><br>
                  <label for="pass" class="lab">MOBILE NUMBER</label>
                  <input type="text"  name="mobNo"  class="textfield"pattern="[6-9][0-9]{9}" placeholder="PASSWORD"  >
                  <label for="pass" class="lab">PASSWORD</label>
                  <input type="password"  name="pwd" class="textfield" pattern="[A-Za-z0-9]{8,10}" placeholder="PASSWORD"  >
                  <label for="pass" class="lab">CONFIRM PASSWORD</label>
                  <input type="password"  name="cpwd" class="textfield" pattern="[A-Za-z0-9]{8,10}" placeholder="PASSWORD"  >
                  <br>
                  <br>
                  
                  <button type="submit " class="btn1">Log In</button>
                  <button type="submit " class="btn1"><a href="login.jsp">Back</a></button><br><br>
</form>
</div>
</div>

</body>
</html>
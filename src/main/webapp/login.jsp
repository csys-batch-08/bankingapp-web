<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="RegCss.css">
<style>
.box{
        width:380px;
        height:380px;
        position:relative;
        margin:6% auto; 
        background: transparent;
        padding:20px;
        box:shadow;
        background-image: url("images/bank2.jpg") ;
        background-repeat: no-repeat;
        }
        
.textfield{
     text-align: center;
     border-radius: 15px;
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
}a{
color:white;}
</style>
<title>Login</title>
</head>
<body>
<div class="img">
  <div class="box">
    <form action="login"  method="post">
         
        <h2 align=center>Login</h2>
        <label for="userid" class="lab">EMAIL ID</label><br>
                  <input type="text" class="textfield" name="userId" pattern="[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}" placeholder="EMAIL ID"  ><br><br>
                  <label for="pass" class="lab">PASSWORD</label>
                  <input type="password"  name="pwd" class="textfield" pattern="[A-Za-z0-9]{8,10}" placeholder="PASSWORD"  ><br><br>

            
             <a href="Reg.jsp"> Dont have an account? Please Register! </a> <br><br>
               <button type="submit " class="btn1">Log In</button>
              <button type="submit" class="btn1" ><a href="index.jsp">Back</a></button>
              <a href ="ForgotPassword.jsp">ForgotPassword?</a>
             
             
            
            <%
            String login=(String)session.getAttribute("login");
             if(login!=null)
             {%>
           <h4><%=login %></h4>
             <% }
            %>
            
            
          
         
       </form>
       
       <%session.removeAttribute("login");
       %>
      </div>
      
      </div>
</body>
</html>
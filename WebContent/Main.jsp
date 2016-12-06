<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/Mainstyles.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Smart Health</title>
<%
session.setMaxInactiveInterval(2);
%>

 <script type="text/javascript">
var Msg ='<%=session.getAttribute("getRegisterUserAlert")%>';

 {   
 function alertName1(){
	 if (Msg=="Yes")
 alert("Registered ! Login To continue");
 } 
 }
 </script > 
 
 <script type="text/javascript">
var Msg ='<%=session.getAttribute("getRegisterModAlert")%>';

 {
 function alertName2(){
	 if (Msg=="Yes")
 alert("Registered ! Login To continue");
 } 
 }
 </script> 
  
 <script type="text/javascript">
var Msg ='<%=session.getAttribute("QuitMessage")%>';
 {
 function alertName(){
	 if (Msg =="quitting")
 alert("Quitted! You can Reactivate whenever you feel");
 } 
 }
 </script>
 

</head>
<body>
   <div class="ImageContainer">
   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>

   	</div>
  
    <div class="FormContainer">
       <span class="ErrorMsg" style="color:#FF0000;">${errorMessage} </span>
    	<form name="LoginForm" method="post" action="MainServlet">
    		<p><input class="login" name="umail" type="text" placeholder="Email"> </p>
    		<p><input class="login" name="upwd" type="password" placeholder="Password"></p>
    		<p><input class="button-login" type="submit" value="Login"></p>
    	</form>
    	<span class="Register-Text"> Not a Member ? <a class="regLink" href="Register.jsp">Sign-In</a> </span>
    </div>
   </div>
	 <script type="text/javascript"> window.onload = alertName1;
   window.onload = alertName;
   window.onload = alertName2;
   </script>
</body>
</html>
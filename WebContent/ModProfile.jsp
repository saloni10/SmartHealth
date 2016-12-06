<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Moderator</title>
<link rel="stylesheet" href="CSS/MProfileStyles.css" type="text/css">
<%
session.setMaxInactiveInterval(2);
%>

 <script type="text/javascript">
var Msg ='<%=session.getAttribute("getAlert")%>';
 {
 function alertName(){
	 if (Msg != "null")
 alert("Fields Updated Successfully!");
 } 
 }
 </script>

</head>
<body>


	<script type="text/javascript"> window.onload = alertName; </script>
<div class="Details">
<form action="UpdateServlet" method="get">
<p><center><span class="HeadingLHS">User Profile</span></p></center></br>
<p> <label>Username:</label> <input name="uname" type="text" value="${details[1]}" readonly/>  </p>
<p> <label>Primary Email:</label> <input name="pemail" type="text" value="${details[3]}" readonly/> </p>
<p> <label>Secondary Email:</label> <input name="Upsmail" type="text" value="${details[4]}" required="required" /> </p>
<p > <label>First Name:</label> <input type="text" name="Upfname" value="${details[5]}" required="required"/> </p>
<p > <label>Last Name:</label> <input type="text" name="Uplname" value="${details[6]}" required="required"/> </p>
<p> <label>About Me:</label> <input type="text" name="Upabout" value="${details[7]}" required="required"/> </p>
<p> <label>Photo Url1:</label> <input type="text"name="Upurl1" value="${details[8]}" required="required"/> </p>
<p> <label>Street Number:</label> <input type="text" name="UpSno" value="${details[11]}" required="required" /> </p>
<p> <label>Gov. District:</label> <input type="text" name="Updist" value="${details[14]}" required="required"/> </p>
<p> <label>Postal Area:</label> <input type="text" name="Uparea" value="${details[15]}" required="required"/> </p>
<p> <label>Emergency Contact:</label> <input type="text" name="Upcnt" value="${mcontact}" required="required"/> </p>
<p > <center><input class="update-button" type="submit" value="Update" /></center></p>
</form>

</div>

<div class="ModOptions">
<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
<div class="tasks">

<form action="AddForumServlet" method="get" >
<input type="submit" class="button" value="Create Forum" id="myBtn"/>
</form>
<!--  
<script>
window.onload=function(){
	document.getElementById("myBtn").onclick=function(){
		alert("gyuguigui");
		
	}
}
</script> -->



<form action="VForumServlet"  method="">
<input type="submit" class="button" value="View Forums" />
</form>

<form action="Main.jsp"  method="">
<input type="submit" class="button" value="Logout" />
</form>
</div>
</div>

</body>
</html>
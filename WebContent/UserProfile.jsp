<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/UProfileStyles.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Smart Health</title>
<script>
function getConfirmation()
{
	var retVal = confirm("Are you sure you want to Exit?");
	if (retVal==true)
		return true;
	else 
		return false;
	}
</script>
  
 <script type="text/javascript">
var Msg ='<%=session.getAttribute("ActMessage")%>';
 {
 function alertName23(){
	 if (Msg.equals("deactivated"))
		 { 
 alert("Welcome Back! You Reactivated your account.");}
 } 
 }
 </script>
 <script type="text/javascript">
var Msg ='<%=session.getAttribute("getUpdateAlert")%>';
 {
 function alertName(){
	 if (Msg =="Yes")
		 { 
 alert("Fields updated successfully!");}
 } 
 }
 </script>
</head>
<body>
 	${rmessage}
 	${AlreadyPosted}

<div class="Details">
<form action="UpdateUserServlet" method="get">
<p><center><span class="HeadingLHS">User Profile</span></p></center></br>
<p> <label>Username:</label> <input name="uname" type="text" value="${details[1]}" readonly/>  </p>
<p> <label>Primary Email:</label> <input name="mail1" type="text" value="${details[3]}" required="required" readonly/> </p>
<p> <label>Secondary Email:</label> <input name="Upsmail" type="text" value="${details[4]}" required="required"/> </p>
<p > <label>First Name:</label> <input name="Upfname" type="text" value="${details[5]}" required="required"/> </p>
<p > <label>Last Name:</label> <input name="Uplname" type="text" value="${details[6]}" required="required"/> </p>
<p> <label>About Me:</label> <input name="Upabout" type="text" value="${details[7]}" required="required"/> </p>
<p> <label>Photo Url1:</label> <input name="Upurl1" type="text" value="${details[8]}" required="required"/> </p>
<p> <label>Street Number:</label> <input type="text" name="UpSno" value="${details[11]}" required="required"/> </p>
<p> <label>Gov. District:</label> <input type="text" name="Updist" value="${details[14]}" required="required"/> </p>
<p> <label>Postal Area:</label> <input type="text" name="Uparea" value="${details[14]}"  required="required"/> </p>
<p> <center><input class="update-button" type="submit" value="Update" /></center></p>
</form>
<script type="text/javascript"> window.onload = alertName;
window.onload = alertName23;</script>
	</div>

	<div class="ModOptions">
<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
   	
<div class="tasks">
    
	<form action="ViewFriendsServlet" method="get">
	<input type="submit" class=" button" value= "View Friends" /> </form>
	<form action="SuggestionServlet" method="get">
	<input type="submit" class=" button" value= "Suggestions" /></form>
	<form action="AcceptDeclineServlet" method="get">
	<input type="submit" class=" button" value= "Requests" /></form>
	<form action="QuitServlet" method="get">
	
	<input type="submit" class=" button" value= "Quit" onclick="return confirm('Are you sure you want to Quit?')" />
</form>
<form action="Main.jsp"  method="">
	<input type="submit" class=" button" value= "Logout" />
	</form>
	<form action="WithdrawRequestServlet"  method="get">
	<input type="submit" class=" button" value= "WithDraw Request" />
	</form>
	<form action="AddHealthStatusServlet"  method="get">
	<input type="submit" class=" button" value= "Add Status" />
	</form>
	<form action="ViewForumforUser"  method="get">
	<input type="submit" class=" button" value= "View Forums" />
	</form>
	</div>
	<p>Your Karma is 1 </p>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="CSS/RegisterStyles.css" rel="stylesheet">
<script src="JS/sc.js" type="text/javascript">
</script>
<script  "type="text/javascript">
$(document).ready(function()
		{
	$('#uname').blur(function()
			{
		var name= $('#uname').val();
		$.get('CheckExistingUname',{uname:name},
				function(responseCode){
			if(responseCode=="true")
				{
		
				$('#errordisplay').text("Username not available");
				}
			});
		
			});
		}) ; 
</script>
<script type="text/javascript">
function empty() {
    var x;
    x = document.getElementById("uname").value;
     
    if (document.getElementById("uname").value== ""||document.getElementById("upwd").value== ""||document.getElementById("pmail").value== ""||document.getElementById("smail").value== ""||document.getElementById("fname").value== ""||document.getElementById("lname").value== ""||document.getElementById("url1").value== ""||document.getElementById("sno").value== ""||document.getElementById("pa").value== "") {
        alert("Some Fields Are Empty!");
        return false;
    };
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
<form action="RegisterServlet" method="post">
<p><input class="reg" name="uname"  id="uname" type="text" placeholder="Username" required="required"/></p>
<p class="error" id="errordisplay"></p>
<p><input class="reg" name="upwd" id="upwd" type="password" placeholder="Password" required="required"/> </p>
<p><input class="reg" name="pmail" id="pmail" type="email" placeholder="Primary Email" required="required"/> </p>
<p class="error" id="mailerrordisplay"></p>
<p><input class="reg" name="smail" id="smail" type="email" placeholder="Secondary Email" required="required"/> </p>
<p><input class="reg" name="fname" id="fname" type="text" placeholder="First name" required="required"/> </p>
<p><input class="reg" name="lname" id="lname" type="text" placeholder="Last name" required="required"/> </p>
<p><input class="reg" name="about" type="text" 	placeholder="About Yourself"  required="required"/> </p>
<p><input class="reg" name="url1" id="url1" type="url" placeholder="Photo URL1" required="required"/> </p>
<p><input class="reg" name="url2" type="url" placeholder="Photo URL2" required="required"/> </p>
<p><input class="reg" name="url3" type="url" placeholder="Photo URL3" required="required"/> </p>
<p><input class="reg"  name="StreetNo" id="sno" type="text" placeholder="Street Number" required="required" /> </p>
<p><input class="reg" name="StreetName" type="text" placeholder="Street Name"  required="required" /> </p>
<p><input class="reg" name="MajorMnp" type="text" placeholder="Major Municipality"  required="required" /> </p>
<p><input class="reg" name="GovDistrict" type="text" placeholder="District" required="required"/> </p>
<p><input class="reg" name="PostalArea" id="pa" type="text" placeholder="Postal Area" required="required"/> </p>
<p><input  id="UserType" id="checkbox" name="UserType" type="checkbox" value="mod" onclick="document.getElementById('Econtact').disabled= !this.checked"/> Moderator ?  </p>
<p><input class="reg" name="Econtact" id="Econtact" type="text" disabled="disabled" placeholder="Emergency Contact"/> </p>

<p><input class="button-reg" type="submit" name="Register-Button" value="Register" onClick="return empty()" /> </p>

</form>
</div>
</div>
</body>
</html>
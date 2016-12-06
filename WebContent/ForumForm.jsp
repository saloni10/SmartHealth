<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/RegisterStyles.css" type="text/css">
<title>Forum</title>
</head>
<body>
<div class="ImageContainer">
<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
<div class="FormContainer">
<span class="heading"> Start A New Forum..</span>
<form method="get" action="CreateForumServlet">

${Username}
<input type="hidden" name="frziuname" value="${Username}" />
<p><input class="reg" type="text" name="Topic" placeholder="Topic" required="required"/> </p>
<p> <input class="reg" type="url" name="url" placeholder="URL" required="required"/></p>
<p><input class="reg" type="text" name="summary" placeholder="Summary" required="required"/></p>
<p><input class="button-reg" class="reg" type="submit" name="CreateForum" value="Submit"/></p>
</form>
</div>
</div>
</body>
</html>
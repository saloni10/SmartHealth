<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/ViewFriendsStyles.css" type="text/css">
<title>Insert title here</title>
</head>
<body>

<div class="ImageContainer">
   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
	<p><center><span class="Heading">Your Friend List</span></p></center></br>
<div class="frndContainer">
<center><div class="message">  ${Message} </div></center>

        <c:forEach var="arrayVar" items="${frnds}">

            <div class="IndividualFriendDiv">
             <form action="UnfriendServlet" method="get">
               <p class="name"> <input type="text" name="nm" value=${arrayVar}></p>
            <input type="submit" value="Unfriend"></form>
</div>
        </c:forEach>

    
 </div>
</body>
</html>
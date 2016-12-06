<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/AcceptDeclineStyles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="ImageContainer">
   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
   	
	<p><center><span class="Heading">Friend Requests</span></p></center></br>
<div class="frndContainer">
<div class="message">  ${Message} </div>
        <c:forEach var="arrayVar" items="${requests}">

            <div class="IndividualFriendDiv">
           <form action="ActionOnRequestServlet" method="get">
              <input type="text" name="frname" value=${arrayVar}>
            <input type="submit" name="action" value="Accept" >
            <input type="submit" name="action" value="Decline"> 
            </form>
			</div>
        </c:forEach>


 </div>
</body>
</html>
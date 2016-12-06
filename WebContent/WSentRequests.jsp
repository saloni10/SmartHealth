<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/WRequestsStyles.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="ImageContainer">
   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
	<p><center><span class="Heading">Sent Requests</span></p></center></br>
<div class="SRequestsContainer">
<div class="message">  ${Message} </div>

        <c:forEach var="arrayVar" items="${sentRequests}">

            <div class="IndividualSRequestDiv">
             <form action="WSentRequestServlet" method="get">
               <p class="name"> <input type="text" name="sentUsername" value=${arrayVar}></p>
            <input type="submit" value="Withdraw"></form>
</div>
        </c:forEach>

    
 </div>

</body>
</html>
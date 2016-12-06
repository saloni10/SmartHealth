<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <%@ page import="java.util.ArrayList" %>
       <%@ page import="root.HealthData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/ViewPropertyStyles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>

${EmptyListMessage}


<div class="Left">
<div class="FormContainer">
<p class="head">Add Your Status<p>
 <form action="AddStatusServlet" method="get">
                <select class="reg" name="PropNumber">
               
               <c:forEach var="arrayVar" items="${properties}" varStatus="loop">
             
  			<option value="${loop.index+1}">${arrayVar}</option>
				
					</c:forEach>
						</select>
						 <p> <input class="regi" type="text" placeholder="Enter Property value" name="PropVal" required="required"/> </p>
            <input type="submit" value="Add"></form>



</form>
</div>
</div>
<div class="Right">
<p class="head">Here is what your Friends have posted..<p>
	<p class="head">${EmptyListMessage}</p>
<%
ArrayList<HealthData> list=  (ArrayList<HealthData>) request.getAttribute("frndsdata");
//out.println(list.size());
for(int i=0; i<list.size();i++)
{  %>
<div class="IndividualPropertyDiv">
<p> <%
	out.println(list.get(i).getUsername());
	out.println(list.get(i).getPropertyName());
	out.println(list.get(i).getValue());
	//out.println(list.get(i).getWhenSaved());
	%> </p> </div><%
}
%>

</div>
</body>
</html>
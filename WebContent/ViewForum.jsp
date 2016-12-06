<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/ViewForumStyles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="ImageContainer">
   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
<div class="forumContainer">
<%
ArrayList<String[] > list=  (ArrayList<String[]>) request.getAttribute("fdetails");
//out.println(list.size());
for(int i=0;i<list.size();i++)
{
	%> <div class="IndividualForumDiv"><%
	
	for(int j=0; j<6;j++)
	{  %>
	
	<form method="get" action="ShutServlet">
	<%  if (j==1){
		%>
			<input type="hidden" name="listitems" value=<% out.println(list.get(i)[1]); %> />
			<% 
			
		}
	
	if (j==0)
	{
		%>
		<p> <span class="label"> Topic: </span> <% 
	}
	else if(j==1)
	{  %><span class="label"> URL: </span> <% 
	} 
	else if(j==2)
	{ 
		%><span class="label"> Summary: </span> <% 
	}
	else if(j==3)
	{  %><span class="label"> Username: </span> <%
	
	}
	else if(j==4)
	{  %> <span class="label"> Created on: </span> <% 
	} %>

<input type="text" value=<% out.println(list.get(i)[j]); %>/>
 </p> <%  //out.println(list.get(i)[j]+ "\n"); 
}
	%>
	<input type="Submit" value="Shut"  /> </form></div></br>
<%
}
%>

</div>
</body>
</html>
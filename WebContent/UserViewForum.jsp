<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/UserViewForumStyles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

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
	
	<form method="get">
	
	<%  if (j==5){
		%>
			<input type="hidden" name="FId" value=<% out.println(list.get(i)[5]); %> />
			<% 
			
		}
	if (j==0)
	{
		%>
		<p><span class="label"> Topic: </span> <% 
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
	}
	%>

<input type="text" value=<% out.println(list.get(i)[j]); %>/> <p>
<%//out.println(list.get(i)[j]+ "\n"); 
}
	%>
	<input class="posttxt" type="text" name="postTxt" placeholder="Enter post" />
	<input type="url" name="photoLocation" placeholder="Enter photo URL" />
	<input type="url" name="linkLocation" placeholder="Enter link URL" />
	<input type="url" name="videoLocation" placeholder="Enter video URL" />
	<input type="Submit" value="Post"  onclick="form.action='PostServlet';"  />  </form>
	<form method="get">
	<input type="hidden" name="FId" value=<% out.println(list.get(i)[5]); %> />
	<input type="Submit" value="Display Posts" onclick="form.action='DisplayPostServlet';" />
	</form>
	</div></br>
<%
}
%>
</div>


</body>
</html>
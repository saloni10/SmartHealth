<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="root.Post" %>
      <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/ForumPostStyles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

   	<div class="TextContainer">
   		<h1> Smart Health </h1>
   		<h4> Focused On You !</h4>
   	</div>
   	<div class="postContainer">
   	
   <p class="head">	${EmptyListMessage}</p>

<%
ArrayList<Post> posts =( ArrayList<Post>) request.getAttribute("Forumposts");

for(int i=0;i<posts.size();i++)
{
	%> 
	<div class="PostDiv">
	<form method="get">
	<p>
	<% 
	   out.println(posts.get(i).getUsername());
	
	   out.println(posts.get(i).getForumId());
	   %>
	   <input type="hidden" name="Postuname" value=<% out.println(posts.get(i).getUsername()); %>/>
	     <input type="hidden" name="fid" value=<% out.println(posts.get(i).getForumId()); %>/>
	     <input type="hidden" name="TimeofPost" value=<% out.println(posts.get(i).getTimeCreated()); %>/>
	   <% 
	   out.println(posts.get(i).getTextEntry());
	   %></p>
	   <input type="text" placeholder="Enter Comment" name="cmntTxt" required="required" />
	   <input type="url" name="photoLocation" placeholder="Enter photo URL" required="required"/>
	   <input type="url" name="linkLocation" placeholder="Enter link URL" required="required"/>
	   <input type="url" name="videoLocation" placeholder="Enter video URL" required="required"/>
	   <p>  <input type="submit" value="Comment" onclick="form.action='CommentServlet';"></p> </form>
	   <form method="get">
	    <input type="hidden" name="Postuname" value=<% out.println(posts.get(i).getUsername()); %>/>
	     <input type="hidden" name="fid" value=<% out.println(posts.get(i).getForumId()); %>/>
	     <input type="hidden" name="TimeofPost" value=<% out.println(posts.get(i).getTimeCreated()); %>/>
	  <p> <input type="text" name="stars" placeholder="Give Rating" required="required"/>
	    <input type="submit" value="Rate" onclick="form.action='RateServlet'"> </form></p>
	 
	 </div>
	   <% 
	}

%>
</div>
</body>
</html>
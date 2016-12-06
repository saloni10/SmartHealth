package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseHelper myDb=new DatabaseHelper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User eu =null;
		User m =null;
		if(request.getParameter("UserType")==null)
		{ 
			String p=request.getParameter("PostalArea");
			eu = new EndUser(request.getParameter("uname"),request.getParameter("upwd"),request.getParameter("pmail"),request.getParameter("smail"),request.getParameter("fname"),request.getParameter("lname"),request.getParameter("about"),request.getParameter("url1"),request.getParameter("url2"),request.getParameter("url3"),request.getParameter("StreetNo"),request.getParameter("StreetName"),request.getParameter("MajorMnp"),request.getParameter("GovDistrict"),p);
		   // EndUser eu=new EndUser(request.getParameter("uname"),0,);
			try {
				myDb.InsertAsEndUser(eu);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("getRegisterUserAlert", "Yes");
			 response.sendRedirect("Main.jsp");
		}
		else
		{
			m = new Moderator(request.getParameter("uname"),request.getParameter("upwd"),request.getParameter("pmail"),request.getParameter("smail"),request.getParameter("fname"),request.getParameter("lname"),request.getParameter("about"),request.getParameter("url1"),request.getParameter("url2"),request.getParameter("url3"),request.getParameter("StreetNo"),request.getParameter("StreetName"),request.getParameter("MajorMnp"),request.getParameter("GovDistrict"),request.getParameter("PostalArea"),Integer.parseInt(request.getParameter("Econtact")));
		    try {
				myDb.InsertAsModerator((Moderator) m);
				//myDb.InsertModQualification(request.getParameter("uname"),request.getParameter("qualification"));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    request.getSession().setAttribute("getRegisterModAlert", "Yes");
			 response.sendRedirect("Main.jsp");
		    
		}
	}

}

package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UnfriendServlet
 */
@WebServlet("/UnfriendServlet")
public class UnfriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String fname=request.getParameter("nm");
		Boolean b=false;
	     try {
			b=myDb.Unfriend(uname,fname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	     String userDetail[]=null;
			int uId=0;
			
			 String umail;
			try {
				umail = myDb.UsernametoPmail(uname);
				uId=myDb.PmailtoUserTypeid(umail);
				userDetail=myDb.PmailToAll(umail);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("details", userDetail);
			request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
	     //response.sendRedirect("UserProfile.jsp");
	    //request.getRequestDispatcher("ViewFriends.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
		doGet(request, response);
	}

}

package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ActionOnRequestServlet")
public class ActionOnRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String action=request.getParameter("action");
		String fname=request.getParameter("frname");
		if(("Accept").equals(action))
		{
			try {
				myDb.acceptRequests(uname,fname);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(("Decline").equals(action))
		{
			try {
				myDb.declineRequests(uname,fname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class ShutServlet
 */
@WebServlet("/ShutServlet")
public class ShutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DatabaseHelper myDb =new  DatabaseHelper();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		String uname=(String) session.getAttribute("Username");
		System.out.println("username "+ uname);
		String url = request.getParameter("listitems");
		try {
			myDb.shutForum(uname,url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("URL "+url);
		 String userDetail[]=null;
			int uId=0;
			
			 String umail;
			try {
				umail = myDb.UsernametoPmail(uname);
				uId=myDb.PmailtoUserTypeid(umail);
				userDetail=myDb.PmailToAll(umail);
				request.setAttribute("mcontact",myDb.ModUnameToEmergencyContact(uname) );
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("details", userDetail);
			
			//request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
		request.getRequestDispatcher("ModProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

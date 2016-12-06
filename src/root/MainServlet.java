package root;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	public DatabaseHelper myDb=new DatabaseHelper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String umail=request.getParameter("umail");
		String upwd=request.getParameter("upwd");
		Boolean existing_user=false;
		Boolean mark_quit = false;
		
		try {
	      existing_user = myDb.isMember(umail,upwd);
	      mark_quit = myDb.checkQuit(umail);
	      System.out.println("Status" + mark_quit);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(existing_user==true)
		{    
			//response.getWriter().write("Present");
			String uname=null;
			String userDetail[]=null;
			int uId=0;
			 try {
			 uname = myDb.PmailtoUsername(umail);
			 uId=myDb.PmailtoUserTypeid(umail);
			userDetail=myDb.PmailToAll(umail);
			 
			 
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			 HttpSession session = request.getSession(true);
			 if(mark_quit==true)
				{
					System.out.println("Wow " + mark_quit);
					session.setAttribute("ActMessage", "deactivated");
					request.setAttribute("rmessage", "You Reactivated Your Account");
				}
			session.setAttribute("Username", uname);
			 request.setAttribute("details", userDetail);
			 if(uId==11||uId==12||uId==13)
			 { 
				 try {
					myDb.updateUserType(uname);
				} catch (ClassNotFoundException | SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
			 }
			 else if (uId==2)
			 {  session.setAttribute("Username", uname);
				 try {
					request.setAttribute("mcontact",myDb.ModUnameToEmergencyContact(uname) );
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   request.getRequestDispatcher("ModProfile.jsp").forward(request, response);
			   }
		}
		else
		{
			 request.setAttribute("errorMessage", "Invalid Details");
			 request.getRequestDispatcher("Main.jsp").forward(request, response);
		}
		
	}

}

package root;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	Forum forum = new Forum();
	Post post=new Post();
	 Calendar cld=Calendar.getInstance();
	 SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	 String current_date=df.format(cld.getTime());
	 
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean b=false;
		
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
	    String Fid = request.getParameter("FId");
	    String postTxt = request.getParameter("postTxt");
	    String photoLocation = request.getParameter("photoLocation");
	    String linkLocation = request.getParameter("linkLocation");
	    String videoLocation = request.getParameter("videoLocation");
	    int fid= Integer.valueOf(Fid);
		post = forum.createPost(uname,current_date,fid,postTxt,photoLocation,linkLocation,videoLocation);
		try {
			b=myDb.AddPost(post);
			if(b==true)
			{
				response.getWriter().write("Posted");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
			
		if(b==false)
			request.setAttribute("AlreadyPosted", "You have ALREADY posted in this forum!");
		
		request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

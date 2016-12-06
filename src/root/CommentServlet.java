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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Calendar cld=Calendar.getInstance();
	 SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	 String commentTime=df.format(cld.getTime());
    DatabaseHelper myDb= new DatabaseHelper();
    Post post=new Post();
	Comment comment = new Comment();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String Puname = request.getParameter("Postuname");
		String Fid = request.getParameter("fid");
		int fid= Integer.valueOf(Fid);
		String commentTxt = request.getParameter("cmntTxt");
	    String photoLocation = request.getParameter("photoLocation");
	    String linkLocation = request.getParameter("linkLocation");
	    String videoLocation = request.getParameter("videoLocation");
	    String timeOfPost=request.getParameter("TimeofPost");
		comment= post.createComment(Puname, timeOfPost, uname, commentTime,commentTxt, photoLocation, videoLocation, linkLocation);
		try {
			myDb.CommentOnPost(comment);
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
		//request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

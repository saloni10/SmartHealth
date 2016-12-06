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
 * Servlet implementation class CreateForumServlet
 */
@WebServlet("/CreateForumServlet")
public class CreateForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Calendar cld=Calendar.getInstance();
	 SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	 String current_date=df.format(cld.getTime());
	 
    DatabaseHelper myDb=new DatabaseHelper();
    ForumController fc= new ForumController();
    Forum forum=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		String uname=(String) session.getAttribute("Username");
		String uname1 = request.getParameter("frziuname");
		String topic = request.getParameter("Topic");
		String url = request.getParameter("url");
		String summary = request.getParameter("summary");
		
		try {
			int id=myDb.getRecentFID();
			System.out.println("Username " + uname1);
			forum=new Forum(id,topic,url,summary,current_date,null,uname1,null);
			//myDb.createForum(forum);
			
			fc.createForum(forum);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		//request.getRequestDispatcher("ModProfile.jsp").forward(request, response);
	request.getRequestDispatcher("ForumForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

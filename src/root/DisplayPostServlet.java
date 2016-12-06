package root;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayPostServlet
 */
@WebServlet("/DisplayPostServlet")
public class DisplayPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseHelper myDb = new DatabaseHelper();
    ArrayList<Post> postsOnForum = new ArrayList<Post>();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		System.out.println("herethere");
	    String Fid = request.getParameter("FId");
	    int fid= Integer.valueOf(Fid);
	    try {
			postsOnForum= myDb.displayPosts(fid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(postsOnForum.isEmpty())
		{
		System.out.println("empty arraylist");
		request.setAttribute("EmptyListMessage", "No Posts To Display" );
		}
	  //  System.out.println(fid + "in Display Posts");
	    request.setAttribute("Forumposts", postsOnForum);
	    request.getRequestDispatcher("ForumPosts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

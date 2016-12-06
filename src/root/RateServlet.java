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
 * Servlet implementation class RateServlet
 */
@WebServlet("/RateServlet")
public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DatabaseHelper myDb= new DatabaseHelper();
	 Post post=new Post();
     Rating rate = new Rating();
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("in Rate Servlet");
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String star = request.getParameter("stars");
		int stars = Integer.valueOf(star);
		String Puname = request.getParameter("Postuname");
		 String timeOfPost=request.getParameter("TimeofPost");
		rate = post.addRating(Puname, timeOfPost, uname, stars);
		try {
			myDb.RateOnPost(rate);
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

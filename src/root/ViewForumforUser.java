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
 * Servlet implementation class ViewForumforUser
 */
@WebServlet("/ViewForumforUser")
public class ViewForumforUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	ArrayList<String[]> fpDetails= new ArrayList<String[]>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		try {
			myDb.ViewForum();
			fpDetails= myDb.ViewForum();
			System.out.println(fpDetails.size());
			int i;
			for(i=0;i<fpDetails.size();i++)
			{
				System.out.println(fpDetails.get(i)[0]);
			}
			System.out.println("hguiui"+ fpDetails.get(1)[0]);
			request.setAttribute("fdetails",fpDetails);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.getRequestDispatcher("UserViewForum.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class AddHealthStatusServlet
 */
@WebServlet("/AddHealthStatusServlet")
public class AddHealthStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	ArrayList<HealthData> frndsData = new ArrayList<HealthData>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String PropList[]=null;
		
		
		try {
			PropList=myDb.displayProperty();
			
			frndsData=myDb.viewFriendsStatus(uname);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(frndsData.isEmpty())
		{
		System.out.println("empty arraylist");
		request.setAttribute("EmptyListMessage", "No Friends Data To Display" );
		}
		
		request.setAttribute("frndsdata", frndsData);
		//System.out.println(frndsData.get(1).getPropertyName());
		request.setAttribute("properties", PropList);
		request.getRequestDispatcher("ViewProperties.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

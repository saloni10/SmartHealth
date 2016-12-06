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
 * Servlet implementation class AddStatusServlet
 */
@WebServlet("/AddStatusServlet")
public class AddStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	HealthData hd=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		
	    int selectedProp=Integer.parseInt(request.getParameter("PropNumber"));
		int propval=Integer.parseInt(request.getParameter("PropVal"));
		System.out.print("SelectProp "+selectedProp);
		System.out.print("SelectPropVal "+propval);
		hd= new HealthData(uname,selectedProp,propval);
		 
		try {
			myDb.AddData(hd);
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

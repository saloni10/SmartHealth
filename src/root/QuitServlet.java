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
 * Servlet implementation class QuitServlet
 */
@WebServlet("/QuitServlet")
public class QuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated metod stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		System.out.println(uname);
		Boolean b=false;
		try {
			b=myDb.markQuit(uname);
			if(b==true)
			{
				request.getSession().setAttribute("QuitMessage", "quitting");
				 response.sendRedirect("Main.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

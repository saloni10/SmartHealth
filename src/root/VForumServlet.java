package root;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VForumServlet")
public class VForumServlet extends HttpServlet {
	
	ArrayList<String[]> fpDetails= new ArrayList<String[]>();
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    try {
			fpDetails= myDb.ViewForum();
			System.out.println(fpDetails.size());
			int i;
			for(i=0;i<fpDetails.size();i++)
			{
				System.out.println(fpDetails.get(i)[0]);
			}
			//System.out.println("hguiui"+ fpDetails.get(1)[0]);
			request.setAttribute("fdetails",fpDetails);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.getRequestDispatcher("ViewForum.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	}

}

package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
   
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String UpdatedModDetails[]=null;
		int mcontact=0;
		String uname=request.getParameter("uname");
		String pmail=request.getParameter("pemail");
		String UpdatedSmail=request.getParameter("Upsmail");
		String Updatedfname= request.getParameter("Upfname");
		String Updatedlname= request.getParameter("Uplname");
		String Updatedabout= request.getParameter("Upabout");
		String Updatedurl1= request.getParameter("Upurl1");
		String UpdatedSno= request.getParameter("UpSno");
		String Updateddist= request.getParameter("Updist");
		String Updatedarea= request.getParameter("Uparea");
		int Updatedcontact= Integer.parseInt(request.getParameter("Upcnt"));
		try {
			myDb.UpdateMod(uname,UpdatedSmail,Updatedfname,Updatedlname,Updatedabout,Updatedurl1,UpdatedSno,Updateddist,Updatedarea,Updatedcontact);
			UpdatedModDetails=myDb.PmailToAll(pmail);
			mcontact= myDb.ModUnameToEmergencyContact(uname) ;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("details",UpdatedModDetails);
		 request.setAttribute("mcontact",mcontact);
		 request.getSession().setAttribute("getAlert", "Yes");
		 request.getRequestDispatcher("ModProfile.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

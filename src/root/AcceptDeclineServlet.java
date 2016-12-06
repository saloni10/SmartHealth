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
 * Servlet implementation class AcceptDeclineServlet
 */
@WebServlet("/AcceptDeclineServlet")
public class AcceptDeclineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		String requests[]=null;
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	    try {
			requests=myDb.ShowIncomingRequests(uname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
          int i=0,count=0;
		
		for(i=0;i<requests.length;i++)
		{
			if(requests[i]!=null)
				{count++;
				System.out.println("frnds "+requests[i]);}
			
		}
			
		//System.out.println("Length "+count);
		
		String inRequests[]= new String[count];
	//String date[]= new String[count];
		for(i=0;i<count;i++)
		{
			inRequests[i]=requests[i];
			//date[i]=dateCreated[i];
			
			System.out.println("fr "+inRequests[i]);
		}
		
		if(inRequests.length!=0)
			request.setAttribute("requests", inRequests);
			else
				request.setAttribute("Message","No Pending Requests");
		
		request.getRequestDispatcher("AcceptDecline.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WithdrawRequestServlet")
public class WithdrawRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] SRequests=null;
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		
		try {
			SRequests=myDb.ShowSentRequests(uname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			int i=0,count=0;
		
		for(i=0;i<SRequests.length;i++)
		{
			if(SRequests[i]!=null)
				count++;
				//System.out.println("frnds "+frndList[i]);}
			
		}
		//System.out.println("Length "+count);
		
		String SentRequests[]= new String[count];
		//String date[]= new String[count];
		for(i=0;i<count;i++)
		{
			SentRequests[i]=SRequests[i];
			
		}
		if(SentRequests.length!=0)
		  request.setAttribute("sentRequests", SentRequests);
		
		else
			request.setAttribute("Message","You have no unAnswered Sent Requests");
		
	request.getRequestDispatcher("WSentRequests.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

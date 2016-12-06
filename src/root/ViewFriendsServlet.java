package root;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ViewFriendsServlet")
public class ViewFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String frndList[]= null;
		//String dateCreated[]= null;
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		try {
			frndList=myDb.viewFriendlist(uname);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0,count=0;
		
		for(i=0;i<frndList.length;i++)
		{
			if(frndList[i]!=null)
				{count++;
				System.out.println("frnds "+frndList[i]);}
			
		}
		System.out.println("Length "+count);
		
		String frnd[]= new String[count];
		//String date[]= new String[count];
		for(i=0;i<count;i++)
		{
			frnd[i]=frndList[i];
			//date[i]=dateCreated[i];
			
			System.out.println("fr "+frnd[i]);
		}
		//String[] arr= {"pavas","puneet","swati"};
		
		
		if(frnd.length!=0)
		{
		request.setAttribute("frnds", frnd);
		//request.setAttribute("dates", date);
		}
		else
			request.setAttribute("Message","You have No friends");
	request.getRequestDispatcher("ViewFriends.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

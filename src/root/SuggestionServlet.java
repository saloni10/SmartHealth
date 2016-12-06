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
 * Servlet implementation class SuggestionServlet
 */
@WebServlet("/SuggestionServlet")
public class SuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseHelper myDb=new DatabaseHelper();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String insuggest[]=null;
	
		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("Username");
		try {
			insuggest=myDb.Suggestions(uname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0,count=0;
		
		for(i=0;i<insuggest.length;i++)
		{   
			if(insuggest[i]!=null)
			{	count++;
			}
		//ystem.out.println("Suggestions "+insuggest[i]);
		}
		String[] suggest=new String[count];
		for(i=0;i<count;i++)
		{
			suggest[i]=insuggest[i];
			
			System.out.println("list "+insuggest[i]);
		}
		
		if(suggest.length!=0)
			request.setAttribute("suggestedFriends", suggest);
			
			else
				request.setAttribute("Message","No Suggestions");
		
		request.getRequestDispatcher("Suggestions.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

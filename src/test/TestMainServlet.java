package test;
import root.*;
import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestMainServlet {

	@Mock
	private HttpServletRequest request;
	 @Mock
	private HttpServletResponse response;
	 @Mock
	private HttpSession session;

	 @Mock
	 private RequestDispatcher rd;
	 
	 @Mock
	private DatabaseHelper db;


	    @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }
	    
	    
	    @Test
	    public void test() throws Exception {

	    	
	    	
	     /*HttpServletRequest request = mock(HttpServletRequest.class);
	     HttpServletResponse response = mock(HttpServletResponse.class);
	     HttpSession session = mock(HttpSession.class);
	     RequestDispatcher rd=mock(RequestDispatcher.class);
	      */
	    	new MainServlet().myDb =db;
	     when(request.getParameter("umail")).thenReturn("s1@gmail.com");
	     when(request.getParameter("upwd")).thenReturn("sal");
	 //    when(request.getParameter("rememberMe")).thenReturn("Y");
	     when(request.getSession()).thenReturn(session);
	     when(request.getRequestDispatcher("ModProfile.jsp")).thenReturn(rd);
	     String umail="s1@gmail.com";
         when(db.PmailtoUsername(umail)).thenReturn("saloni");
         //when(db.PmailtoUsername("s1@gmail.com")).thenReturn("saloni");
         //when(db.PmailtoUsername("s1@gmail.com")).thenReturn("saloni");

	     StringWriter sw = new StringWriter();
	     PrintWriter pw = new PrintWriter(sw);
	     
	     when(response.getWriter()).thenReturn(pw);
	     
	     new MainServlet().doPost(request, response);
	     
	     //Verify the session attribute value
	     verify(session).setAttribute("Username", "saloni");
	     
	     verify(rd).forward(request, response);
	     
	     String result = sw.getBuffer().toString().trim();

	     System.out.println("Result: "+result);
	     
	     assertEquals("Logged", result);
	    }
	    

}

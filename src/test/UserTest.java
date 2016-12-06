package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import root.DatabaseHelper;
import root.FriendshipControlller;
import root.UserController;

public class UserTest {

	 @Mock
	    private DatabaseHelper mydb;
	    
	    @Before
	    public void setup()
	    {
	    	MockitoAnnotations.initMocks(this);
	    }
	    
	    UserController uc = new UserController();
		
	@Test
	public void checkMember() throws ClassNotFoundException, SQLException {
	
		boolean isMember1= uc.isMember("y1@gmail.com", "yas");
		 assertEquals(true,isMember1);
		 boolean isMember2= uc.isMember("y1@gmail.com", "yashi");
		 assertEquals(false,isMember2);
		
	}
	
	@Test
	public void mailtouser() throws ClassNotFoundException, SQLException {
		 String Username1= uc.isUsername("y1@gmail.com");
		 assertEquals("yashika",Username1);
		 String Username2= uc.isUsername("p1@gmail.com");
		 assertEquals("puneet",Username2);
		
	}
	
	@Test
	public void usertomail() throws ClassNotFoundException, SQLException {
		 String mail1= uc.isPmail("yashika");
		 assertEquals("y1@gmail.com",mail1);
		 String mail2= uc.isPmail("puneet");
		 assertEquals("p1@gmail.com",mail2);
		
	}
	
	@Test
	public void mailtoid() throws ClassNotFoundException, SQLException {
		 int id1= uc.isUserTypeid("y1@gmail.com");
		 assertEquals(11,id1);
		 int id2= uc.isUserTypeid("s1@gmail.com");
		 assertEquals(2,id2);
		
	}
	
	@Test
	public void emergencyContact() throws ClassNotFoundException, SQLException {
		int contact1= uc.isEmergencyContact("saloni");
		 assertEquals(1234567,contact1);
		 int contact2= uc.isEmergencyContact("seemaly");
		 assertEquals(1234,contact2);
	}
	@Test
	public void existingUsername() throws ClassNotFoundException, SQLException {
		
		String exist1=uc.isExistingUsername("yashika");
		assertEquals("true",exist1);
		String exist2=uc.isExistingUsername("yashi");
		assertEquals("false",exist2);

	}
	@Test
	public void isquit() throws ClassNotFoundException, SQLException {
		
		Boolean status=uc.markQuit("yashika");
		assertEquals(true,status);
	}
}
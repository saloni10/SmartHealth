package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import root.DatabaseHelper;
import root.FriendshipControlller;

public class FriendshipTest {

	 @Mock
	 private DatabaseHelper mydb;
	    
	    @Before
	    public void setup()
	    {
	    	MockitoAnnotations.initMocks(this);
	    }
	    
	    FriendshipControlller fc = new FriendshipControlller();
		
	/*@Test
	public void countFriends() throws ClassNotFoundException, SQLException {
		
		fc.myDb=mydb;
		int length=fc.viewFriendlist("akash").length;
		assertEquals(0,length);
		
	}*/
	
	@Test
	public void ShouldBeFriends() throws ClassNotFoundException, SQLException
	{
	 fc.myDb=mydb;
	 boolean isFriend= fc.isFriend("akash", "puneet");
	 assertEquals(false,isFriend);
	}
	
	
	@Test
	public void ShouldUnfriend() throws ClassNotFoundException, SQLException
	{
	fc.myDb=mydb;
	 boolean unfriended= fc.Unfriend("akash", "puneet");
	 assertEquals(false, unfriended);
	}
	


}

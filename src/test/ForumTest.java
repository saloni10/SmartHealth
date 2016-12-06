package test;
import root.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ForumTest {
	
	@Mock
	private DatabaseHelper mydb;
	
	@Before
	public void setup(){
	MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createPost_shouldCreatePost() throws ClassNotFoundException, SQLException {
		
		ForumController fc=new ForumController();
		fc.myDb=mydb;
		Forum forum= new Forum(2,"abc","xyz","efg","ijk","lmn","opq","rst");
		when(mydb.createForum(forum)).thenReturn(true);
		boolean result=fc.createForum(forum);
		assertTrue(result);
			
	}	
	
	@Test
	public void shouldReturn_RecentForumID() throws ClassNotFoundException, SQLException {
		
		ForumController fc=new ForumController();
		fc.myDb=mydb;
		Forum forum= new Forum(2,"a","b","c","d","e","f","g");
		when(mydb.getRecentFID()).thenReturn(17);//Recent Fid presently is 17
		
		int result=fc.getRecentFID();
		assertEquals(result,17);
			
	}	

}

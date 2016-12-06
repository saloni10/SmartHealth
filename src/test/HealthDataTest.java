package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import root.DatabaseHelper;
import root.HealthData;
import root.HealthDataController;

public class HealthDataTest {
 
   

	
    @Mock
     private DatabaseHelper mydb;
    
    @Before
    public void setup()
    {
    	MockitoAnnotations.initMocks(this);
    }

  
    HealthData hd= new HealthData("mayank",2,300);
		
		
	/*@Test
	public void PropertyListSize() throws ClassNotFoundException, SQLException
	{  
		
		HealthDataController hdc = new HealthDataController();
		hdc.myDb=mydb;
		int length=hdc.displayProp().length;
		assertEquals(3,length);
	}*/
	
	@Test
	public void FriendsStatusListSize() throws ClassNotFoundException, SQLException
	{
		HealthDataController hdc = new HealthDataController();
		hdc.myDb=mydb;
		int length=hdc.viewFriendsStatus("yashika").size();
		assertEquals(0,length);
	}
	
	

}

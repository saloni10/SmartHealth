/*
 * Forum Controller Class containing all functions which interact with the model class
 * All functions to implement the functions of a Forum(Creating Forums,Displaying Forums etc.)
 */
package root;

import java.sql.SQLException;

public class ForumController {
	
	public DatabaseHelper myDb= new DatabaseHelper();
	
	
	
	public boolean createForum(Forum f) throws ClassNotFoundException, SQLException
	{
		return myDb.createForum(f);
	}
	
	public int  getRecentFID() throws ClassNotFoundException, SQLException
	{
		return myDb.getRecentFID();
	}

}

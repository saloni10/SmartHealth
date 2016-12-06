/*
 * HealthData Controller Class containing all functions which interact with the model class
 * All functions to implement the functions of a Health Data of various Users(Adding Data,Viewing Friends data etc.)
 */
package root;

import java.sql.SQLException;
import java.util.ArrayList;

public class HealthDataController {
	
	public DatabaseHelper myDb = new DatabaseHelper();
	
	/*
	 * Adding New Health Data of a particular user
	 */
	public void AddData(HealthData hd) throws ClassNotFoundException, SQLException
	{
		myDb.AddData(hd);
	}
	
	/*
	 * Displaying various health related properties
	 */
	public String[] displayProp() throws ClassNotFoundException, SQLException
	{
		return myDb.displayProperty();
	}
	/*
	 * View Friends Health Data of a user
	 */
	public ArrayList<HealthData> viewFriendsStatus(String uname) throws ClassNotFoundException, SQLException
	{
		return myDb.viewFriendsStatus(uname);
	}

}

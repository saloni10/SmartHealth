/*
 * User Controller Class containing all functions which interact with the model class
 * All functions to implement the functions of a User Profile
 */

package root;
import java.sql.SQLException;

public class UserController {

	public DatabaseHelper myDb = new DatabaseHelper();
	
	/*
	 * Function to check if a particular email and password is a valid entry or not
	 */
	public boolean isMember(String pemail, String pwd) throws SQLException, ClassNotFoundException
	{ 
		System.out.println("testing "+ myDb.isMember(pemail,pwd));
	    return myDb.isMember(pemail,pwd);
	}
	
	/*
	 * Getting username for a particular email of a user
	 */
	public String isUsername(String pemail) throws ClassNotFoundException, SQLException
	{
		return myDb.PmailtoUsername(pemail);
	}
	
	/*
	 * Getting email for a particular username of a user
	 */
	public String isPmail(String name) throws ClassNotFoundException, SQLException
	{
		return myDb.UsernametoPmail(name);
	}
	
	/*
	 * Email to userID(Admin,Moderator,RegularUser)
	 */
	public int isUserTypeid(String pemail) throws ClassNotFoundException, SQLException
	{
		return myDb.PmailtoUserTypeid(pemail);
	}
	
	/*
	 * getting Emergency Contact of Moderator
	 */
	public int isEmergencyContact(String mname) throws ClassNotFoundException, SQLException
	{
		return myDb.ModUnameToEmergencyContact(mname);
	}
	
	/*
	 * For checking the availabilty of a Username
	 */
	public String isExistingUsername(String name) throws ClassNotFoundException, SQLException
	{ 
		System.out.println(myDb.isExistingUsername(name));
		return myDb.isExistingUsername(name);
	}
	
	/*
	 * Update status of user if present in system or quitted from the system
	 */
	public boolean markQuit(String uname) throws ClassNotFoundException, SQLException
	{  
		return myDb.markQuit(uname);
	}
}

/*
 * Friendship Controller Class containing all functions which interact with the model class
 * All functions to implement the functions of a Friendship(View Friends,Send/Receive Requests etc)
 */
package root;

import java.sql.SQLException;

public class FriendshipControlller {

	public DatabaseHelper myDb = new DatabaseHelper();

	/*
	 * 
	 */
	public String[] viewFriendlist(String uname) throws ClassNotFoundException, SQLException {
		return myDb.viewFriendlist(uname);
	}

	public boolean isFriend(String uname, String fname) throws ClassNotFoundException, SQLException {
		return myDb.isFriend(uname, fname);
	}

	public boolean Unfriend(String uname, String fname) throws ClassNotFoundException, SQLException {
		return myDb.Unfriend(uname, fname);
	}

	public String[] suggestions(String uname) throws ClassNotFoundException, SQLException {
		return myDb.Suggestions(uname);
	}

}

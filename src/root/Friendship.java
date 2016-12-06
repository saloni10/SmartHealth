package root;
/*
 * Class depicting the Social Network functionality in the system
 * Depicts Friendship between End Users
 */

public class Friendship {

	
	private String Requester_Username;
	private String Requested_Username;
	
	/*
	 * Getters and Setters
	*/
	public String getRequester_Username() {
		return Requester_Username;
	}
	
	public void setRequester_Username(String requester_Username) {
		Requester_Username = requester_Username;
	}
	
	public String getRequested_Username() {
		return Requested_Username;
	}
	
	public void setRequested_Username(String requested_Username) {
		Requested_Username = requested_Username;
	}
	
	
	/*
	 * Constructor to initialize Friendship variables
	 */
	Friendship(String Requester_Username,String Requested_Username)
	{
		this.Requester_Username=Requester_Username;
		this.Requested_Username=Requested_Username;
		
	}
}

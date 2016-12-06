package root;
/*
 * The child class of User depicting Moderators in the system
 */

public class Moderator extends User {
 
	private int emergencyContact;
	private int qualification;
	
	
	
	public int getEmergencyContact() {
		return emergencyContact;
	}



	public void setEmergencyContact(int emergencyContact) {
		this.emergencyContact = emergencyContact;
	}



	/*
	 * Constructor for initializing variables of Modersator class
	 */
	Moderator(String un, String pass,String pe,String se,String fn,String ln,String am,String u1,String u2, String u3,String sn,String snam, String mun, String dst,String pa,int ec)
	{
		super(un,pass, pe, se, fn, ln, am, u1, u2, u3,sn,snam,mun,dst,pa,2,false);
		this.emergencyContact=ec;
	}
	
}

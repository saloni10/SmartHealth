package root;
/*
 * The child class of User depicting Admin of the system
 */
public class Admin extends User {

	/*
	 * Constructor to initialize variables of Administrator
	 */
	Admin(String uname, String pwd, String pmail, String smail, String fname, String lname, String about, String pu1,
			String pu2, String pu3, String Sno, String Sname, String mun, String district, String area, int id,
			boolean status) {
		super(uname, pwd, pmail, smail, fname, lname, about, pu1, pu2, pu3, Sno, Sname, mun, district, area, id, status);
	}

	private int emergencyContact;

	
	/*
	 * Getters and Setters
	*/
	public int getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(int emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
}

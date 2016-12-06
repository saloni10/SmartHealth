package root;

/*
 * The child class of User depicting End Users in the system
 */

public class EndUser extends User{
	
	private int karma;

	/*
	 * Getters and Setters
	*/
	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}
	
  
   /*
    * Constructor for initializing variables of EndUser
    */
	   EndUser(String un, String pass,String pe,String se,String fn,String ln,String am,String u1,String u2, String u3,String sn,String snam, String mun, String dst,String pa)
		{
			super(un,pass, pe, se, fn, ln, am, u1, u2, u3,sn,snam,mun,dst,pa,11,false);
			  this.karma=0;
		}
	 
   
}

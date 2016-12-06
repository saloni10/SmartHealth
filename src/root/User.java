package root;
/*
 * The base class depicting all Users of the system
 */
public class User {

	private String username;
	private String password;
	private String primary_email;
    private String secondary_email;
    private String first_name;
    private String last_name;
	private String about_me;
	private String photo_url1;
	private String photo_url2;
	private String photo_url3;
	private String street_number;
	private String street_name;
	private String major_municipality;
	private String governing_district;
	private String postal_area;
	private int user_typeID;
	private boolean mark_quit;
	
	/*
	 * Getters and Setters
	*/
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrimary_email() {
		return primary_email;
	}
	public void setPrimary_email(String primary_email) {
		this.primary_email = primary_email;
	}
	public String getSecondary_email() {
		return secondary_email;
	}
	public void setSecondary_email(String secondary_email) {
		this.secondary_email = secondary_email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public String getPhoto_url1() {
		return photo_url1;
	}
	public void setPhoto_url1(String photo_url1) {
		this.photo_url1 = photo_url1;
	}
	public String getPhoto_url2() {
		return photo_url2;
	}
	public void setPhoto_url2(String photo_url2) {
		this.photo_url2 = photo_url2;
	}
	public String getPhoto_url3() {
		return photo_url3;
	}
	public void setPhoto_url3(String photo_url3) {
		this.photo_url3 = photo_url3;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getMajor_municipality() {
		return major_municipality;
	}
	public void setMajor_municipality(String major_municipality) {
		this.major_municipality = major_municipality;
	}
	public String getGoverning_district() {
		return governing_district;
	}
	public void setGoverning_district(String governing_district) {
		this.governing_district = governing_district;
	}
	public String getPostal_area() {
		return postal_area;
	}
	public void setPostal_area(String postal_area) {
		this.postal_area = postal_area;
	}
	public int getUser_typeID() {
		return user_typeID;
	}
	public void setUser_typeID(int user_typeID) {
		this.user_typeID = user_typeID;
	}
	public boolean isMark_quit() {
		return mark_quit;
	}
	public void setMark_quit(boolean mark_quit) {
		this.mark_quit = mark_quit;
	}
	
	/*
	 * Constructor for initializing variables values
	 */
	User(String uname, String pwd, String pmail, String smail, String fname, String lname,String about, String pu1, String pu2, String pu3, String Sno, String Sname, String mun, String district, String area, int id,boolean status)
	{
		this.username=uname;
		this.password=pwd;
		this.primary_email=pmail;
		this.secondary_email=smail;
		this.first_name=fname;
		this.last_name=lname;
		this.photo_url1=pu1;
		this.photo_url2=pu2;
		this.photo_url3=pu3;
		this.street_number=Sno;
		this.street_name=Sname;
		this.major_municipality=mun;
		this.governing_district=district;
		this.user_typeID=id;
		this.mark_quit=status;
		
	}
}

package root;
/*
 * Class depicting the Rating functionality in the system
 */

public class Rating {

	
	private String PostUsername;
	private String PostTimeCreated;
	private String RaterUsername;
	private int stars;
	
	
	/*
	 * Getters and Setters
	*/
	public String getPostUsername() {
		return PostUsername;
	}
	
	public void setPostUsername(String postUsername) {
		PostUsername = postUsername;
	}
	
	public String getPostTimeCreated() {
		return PostTimeCreated;
	}
	
	public void setPostTimeCreated(String postTimeCreated) {
		PostTimeCreated = postTimeCreated;
	}
	
	public String getRaterUsername() {
		return RaterUsername;
	}
	
	public void setRaterUsername(String raterUsername) {
		RaterUsername = raterUsername;
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	 Rating()
	 {
		 
	 }

	 /*
	  * Constructor to initialize variables of Rating Class 
	  */
	public Rating(String postUsername, String postTimeCreated, String raterUsername, int stars) {
		super();
		PostUsername = postUsername;
		PostTimeCreated = postTimeCreated;
		RaterUsername = raterUsername;
		this.stars = stars;
	}
	
	
}

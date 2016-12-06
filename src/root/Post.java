package root;
/*
 * Class depicting the Post functionality in the system
 */

import java.util.ArrayList;

public class Post {

	private ArrayList<Comment> comments= new ArrayList<Comment>();
	private ArrayList<Rating> ratings= new ArrayList<Rating>();
	
	/*
	 * Adds New comments to a post
	 */
	public Comment createComment(String Puname,String Pdate, String Cuname, String commentTime,String commentTxt,String photoLocation, String videoLocation, String linkLocation)
	{
	Comment comment= new Comment(Puname,Pdate,Cuname,commentTime,commentTxt,photoLocation,videoLocation,linkLocation);
	comments.add(comment);
	return comment;
	}
	
	/*
	 * Adds rating to a post 
	 */
	Rating addRating(String postUsername, String postTime, String raterUsername, int stars)
	{
		Rating rate = new Rating(postUsername,postTime, raterUsername, stars);
        ratings.add(rate);
        return rate;
	}
	
	private String Username;
	private String timeCreated;
	private int ForumId;
	private String TextEntry;
	private String PhotoLocation;
	private String VideoLocation;
	private String LinkLocation;
	
	
	/*
	 * Getters and Setters
	*/
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public int getForumId() {
		return ForumId;
	}
	public void setForumId(int forumId) {
		ForumId = forumId;
	}
	public String getTextEntry() {
		return TextEntry;
	}
	public void setTextEntry(String textEntry) {
		TextEntry = textEntry;
	}
	public String getPhotoLocation() {
		return PhotoLocation;
	}
	public void setPhotoLocation(String photoLocation) {
		PhotoLocation = photoLocation;
	}
	public String getVideoLocation() {
		return VideoLocation;
	}
	public void setVideoLocation(String videoLocation) {
		VideoLocation = videoLocation;
	}
	public String getLinkLocation() {
		return LinkLocation;
	}
	public void setLinkLocation(String linkLocation) {
		LinkLocation = linkLocation;
	}
	
	/*
	 * Constructor for initializing variables of Post 
	 */
	public Post(String username, String timeCreated, int forumId, String textEntry, String photoLocation,
			String videoLocation, String linkLocation) {
	
		Username = username;
		this.timeCreated = timeCreated;
		ForumId = forumId;
		TextEntry = textEntry;
		PhotoLocation = photoLocation;
		VideoLocation = videoLocation;
		LinkLocation = linkLocation;
	}
	
	Post()
	{
		
	}
	
	
	
	
}

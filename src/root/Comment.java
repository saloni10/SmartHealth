package root;
/*
 * Class depicting the comment functionality in the system
 */

public class Comment {
	
	private String PostUsername;
	private String PostTimeCreated;
	private String Commenter_Username;
	private String CommentText;
	private String CommentTime;
	public String getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(String commentTime) {
		CommentTime = commentTime;
	}

	private String PhotoLocation;
	private String LinkLocation;
	private String VideoLocation;
	
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
	public String getCommenter_Username() {
		return Commenter_Username;
	}
	public void setCommenter_Username(String commenter_Username) {
		Commenter_Username = commenter_Username;
	}
	public String getCommentText() {
		return CommentText;
	}
	public void setCommentText(String commentText) {
		CommentText = commentText;
	}
	public String getPhotoLocation() {
		return PhotoLocation;
	}
	public void setPhotoLocation(String photoLocation) {
		PhotoLocation = photoLocation;
	}
	public String getLinkLocation() {
		return LinkLocation;
	}
	public void setLinkLocation(String linkLocation) {
		LinkLocation = linkLocation;
	}
	public String getVideoLocation() {
		return VideoLocation;
	}
	public void setVideoLocation(String videoLocation) {
		VideoLocation = videoLocation;
	}
	
	Comment()
	{
		
	}
	
	/*
	 * Constructor to initialize variables of Comment
	 */
	public Comment(String postUsername, String postTimeCreated, String commenter_Username, String commentTime, String commentText,
			String photoLocation, String linkLocation, String videoLocation) {
		
		PostUsername = postUsername;
		PostTimeCreated = postTimeCreated;
		Commenter_Username = commenter_Username;
		CommentTime = commentTime;
		CommentText = commentText;
		PhotoLocation = photoLocation;
		LinkLocation = linkLocation;
		VideoLocation = videoLocation;
	}
	
	
	

}

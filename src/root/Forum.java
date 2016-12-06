package root;

import java.util.ArrayList;

/*
 * Class depicting the Forum functionality in the system
 * contains objects of Forum, Comment and Rating to depict composition
 */

public class Forum {

	private ArrayList<Post> posts= new ArrayList<Post>();
	Post createPost(String username,String date, int fid, String postTxt,String photoLocation, String videoLocation, String linkLocation)
	{
	Post post= new Post(username,date,fid,postTxt,photoLocation,videoLocation,linkLocation);
	posts.add(post);
	return post;
	}
//	Comment comment=new Comment();
	//Rating rate= new Rating();
	
	/*
	 * Getters and Setters
	*/
	private int ForumID;
	private String Topic;
	private String ForumUrl;
	private String Summary;
	private String CreatedBy;
	private String DeletedBy;
	private String WhenCreated;
	private String WhenClosed;
	
	
	public int getForumID() {
		return ForumID;
	}
	
	public void setForumID(int forumID) {
		ForumID = forumID;
	}
	
	public String getTopic() {
		return Topic;
	}
	
	public void setTopic(String topic) {
		Topic = topic;
	}
	
	public String getForumUrl() {
		return ForumUrl;
	}
	
	public void setForumUrl(String forumUrl) {
		ForumUrl = forumUrl;
	}
	
	public String getSummary() {
		return Summary;
	}
	
	public void setSummary(String summary) {
		Summary = summary;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	
	public String getDeletedBy() {
		return DeletedBy;
	}
	
	public void setDeletedBy(String deletedBy) {
		DeletedBy = deletedBy;
	}
	

	public String getWhenCreated() {
		return WhenCreated;
	}

	public void setWhenCreated(String whenCreated) {
		WhenCreated = whenCreated;
	}

	public String getWhenClosed() {
		return WhenClosed;
	}

	public void setWhenClosed(String whenClosed) {
		WhenClosed = whenClosed;
	}
	Forum()
	{
		
	}

	/*
	    * Constructor for initializing variables of Forum
	    */
	public Forum( int forumID, String topic, String forumUrl, String summary,String WhenCr,String WhenCl, String createdBy,
			String deletedBy) {
		
		ForumID = forumID;
		Topic = topic;
		ForumUrl = forumUrl;
		Summary = summary;
		CreatedBy = createdBy;
		DeletedBy = deletedBy;
		WhenCreated=WhenCr;
		WhenClosed=WhenCl;
	}
	
	
	
	
	
}

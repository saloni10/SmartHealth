package root;
/*
 * The Database Class
 * Contains all the Functions that contain database calls
 * linked with Mysql 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatabaseHelper {
      
	 
	int karma=3;
	/*
	 * Creating Connection to Mysql database
	 */
	Connection con=null;
	public void Connect() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/smarthealthdb","root","nsaloni1110");  
	}
	 Calendar cld=Calendar.getInstance();
	 SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	 String current_date=df.format(cld.getTime());
	 
	/*
	 * Checks membership of User
	 * Checks if the given Email and password are valid
	 */
	public boolean isMember(String pemail, String pwd) throws SQLException, ClassNotFoundException
	{   
		
		Connect();
		Statement st1 =con.createStatement();
		String q = "Select * from User";
		int count=0;
		ResultSet rs1 = st1.executeQuery(q);
		while(rs1.next())
		{
			if(rs1.getString("Email1").equals(pemail)&&rs1.getString("Password").equals(pwd))
			 {
				 count++;
				 break;
			 }
			
		}
		
		if(count==0)
			return false;
		else return true;
	}
	
	/*
	 * Returns Username from the given Email1
	 */
	public String PmailtoUsername(String pemail) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1 =con.createStatement();
		String q = "Select Username from User where Email1= '"+pemail+"'";
		ResultSet rs1 = st1.executeQuery(q);
		rs1.first();
		return(rs1.getString("Username"));
		
	}
	
	/*
	 * Returns Email1 from the given Username
	 */
	public String UsernametoPmail(String name) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1 =con.createStatement();
		System.out.println("email is "+ name);
		String q = "Select Email1 from User where Username= '"+name+"'";
		ResultSet rs1 = st1.executeQuery(q);
		rs1.first();
		System.out.println("email is "+ rs1.getString("Email1"));
		return(rs1.getString("Email1"));
		
	}
	
	/*
	 * Returns UserTypeID from the given Email1
	 */
	public int PmailtoUserTypeid(String pemail) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1 =con.createStatement();
		String q = "Select UserTypeID from User where Email1= '"+pemail+"'";
		ResultSet rs1 = st1.executeQuery(q);
		rs1.first();
		return(rs1.getInt("UserTypeID"));
		
	}
	
	/*
	 * Returns EmergencyContact from the given Username for Moderator
	 */
	public int ModUnameToEmergencyContact(String mname) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1 =con.createStatement();
		String q = "Select Phone from Moderator where Username='"+mname+"'";
		ResultSet rs1 = st1.executeQuery(q);
		rs1.first();
		return(Integer.parseInt(rs1.getString(1)));
	}
	
	/*
	 * Registers EndUser in the system
	 */
	public void InsertAsEndUser(User u) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1=con.createStatement();
		Statement st2=con.createStatement();
		String q1="Insert into User values('"+u.getUsername()+"','"+u.getPassword()+"','"+u.getPrimary_email()+"','"+u.getSecondary_email()+"','"+u.getFirst_name()+"','"+u.getLast_name()+"','"+u.getAbout_me()+"','"+u.getPhoto_url1()+"','"+u.getPhoto_url2()+"','"+u.getPhoto_url3()+"','"+u.getStreet_number()+"','"+u.getStreet_name()+"','"+u.getMajor_municipality()+"','"+u.getGoverning_district()+"','"+u.getPostal_area()+"',"+u.getUser_typeID()+","+u.isMark_quit()+")";
		System.out.println("Postal :"+u.getPostal_area());
		String q="Insert into EndUser values('"+u.getUsername()+"',0,'"+current_date+"')";
		st1.execute(q);
		st2.execute(q1);
	}
	
	/*
	 * Registers Moderator in the system
	 */
	public void InsertAsModerator(Moderator u) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st1=con.createStatement();
		Statement st2=con.createStatement();
		String q="Insert into User values('"+u.getUsername()+"','"+u.getPassword()+"','"+u.getPrimary_email()+"','"+u.getSecondary_email()+"','"+u.getFirst_name()+"','"+u.getLast_name()+"','"+u.getAbout_me()+"','"+u.getPhoto_url1()+"','"+u.getPhoto_url2()+"','"+u.getPhoto_url3()+"','"+u.getStreet_number()+"','"+u.getStreet_name()+"','"+u.getMajor_municipality()+"','"+u.getGoverning_district()+"','"+u.getPostal_area()+"',"+u.getUser_typeID()+","+u.isMark_quit()+")";
		System.out.println("Postal :"+u.getPostal_area());
		String q1="Insert into Moderator values('"+u.getUsername()+"',"+u.getEmergencyContact()+")";
		st1.execute(q);
		st2.execute(q1);
	}
	
	/*
	 * Checks if Username already exists
	 */
	public String isExistingUsername(String name) throws ClassNotFoundException, SQLException
	{ 
		Connect();
		int count=0;
		Statement st1=con.createStatement();
		String q="Select Username from User";
		ResultSet rs= st1.executeQuery(q);
		while(rs.next())
		{
			if(rs.getString("Username").equals(name))
				{
				count++;
				break;
				}
		}
		if(count==0)
		return "false";
		else
			return "true";
	}
	
	/*
	 * Returns all the details of User given Email1
	 */
	public String[] PmailToAll(String pmail) throws ClassNotFoundException, SQLException
	{
		String user[]= new String[17];
		Connect();
		Statement st1=con.createStatement();
		String q="Select * from User where Email1 ='"+pmail+"' ";
		ResultSet rs= st1.executeQuery(q);
		int i;
		rs.first();
		for(i=1;i<user.length;i++)
		{
			user[i]=rs.getString(i);
			System.out.println(user[i]);
		}
		
		return user;
	}
	
	/*
	 * Updates Moderator Details
	 */
	public void UpdateMod(String mname,String msmail, String mfname, String mlname, String mabout, String mpurl1, String msno, String mdist, String marea, int mcnt) throws ClassNotFoundException, SQLException
	{
	  
		Connect();
		Statement st=con.createStatement();
		Statement st1=con.createStatement();
		System.out.println("In uodate"+mname);
		System.out.println("In uodate"+msno);
		String q="Update User Set Email2='"+msmail+"',FirstName='"+mfname+"',LastName='"+mlname+"',AboutMe='"+mabout+"',PhotoURL1='"+mpurl1+"',StreetNumber='"+msno+"',GoverningDistrict='"+mdist+"', PostalArea='"+marea+"' where Username='"+mname+"'";
		String q1="Update Moderator Set Phone="+mcnt+" where Username='"+mname+"'";
		st.execute(q);
		st1.execute(q1);
	}
	
	/*
	 * Updates EndUser Details
	 */
	public void UpdateUser(String mname,String msmail, String mfname, String mlname, String mabout, String mpurl1, String msno, String mdist, String marea) throws ClassNotFoundException, SQLException
	{
	  
		Connect();
		Statement st=con.createStatement();
		Statement st1=con.createStatement();
		System.out.println("In uodate"+mname);
		System.out.println("In uodate"+msno);
		String q="Update User Set Email2='"+msmail+"',FirstName='"+mfname+"',LastName='"+mlname+"',AboutMe='"+mabout+"',PhotoURL1='"+mpurl1+"',StreetNumber='"+msno+"',GoverningDistrict='"+mdist+"', PostalArea='"+marea+"' where Username='"+mname+"'";
		st.execute(q);
		
	}
	
	/*
	 * marks the User as Quitted
	 */
	public boolean markQuit(String uname) throws ClassNotFoundException, SQLException
	{  
		System.out.println("hiu"+uname);
		Connect();
		Statement st=con.createStatement();
		String q="Update User set Status = 1 where Username='"+uname+"' ";
		st.execute(q);
		
		return true;
		
		
	}
	
	/*
	 * returns list of all Forums
	 */
	public ArrayList ViewForum() throws ClassNotFoundException, SQLException
	{ 	
		ArrayList<String[]> fDetails= new ArrayList<String[]>();
		System.out.println("bujyhgyuhgyuhgy");
		
		Connect();
		Statement st=con.createStatement();
		String q="Select ForumID, Topic,URL, Summary,CreatedByModerator_Username,WhenCreated  from Forum where WhenClosed is Null";
		ResultSet rs= st.executeQuery(q);
		while(rs.next())
		{
			String arr[]=new String[6];
		    arr[0]=rs.getString("Topic");
		    System.out.println(arr[0]);
		    arr[1]=rs.getString("URL");
		    System.out.println(arr[1]);
		    arr[2]=rs.getString("Summary");
		    System.out.println(arr[2]);
		    arr[3]=rs.getString("CreatedByModerator_Username");
		    System.out.println(arr[3]);
		    arr[4]=rs.getString("WhenCreated");
		    System.out.println(arr[4]);
		    arr[5]=String.valueOf(rs.getInt("ForumID"));
		    fDetails.add(arr);
		   
		    
		}
		int i;
		
		//System.out.println("  "+fDetails.get(1)[1]);
	
		for(i=0;i<fDetails.size();i++)
		
		
			System.out.println(" dfuyfuy "+fDetails.get(i)[0]);
		
		return fDetails;
		
		
	}

	/*
	 * Returns the Friendlist of User given its Username
	 */
	public String[] viewFriendlist(String uname) throws ClassNotFoundException, SQLException {
		
		String[] frnds=new String[40];
		Connect();
		Statement st=con.createStatement();
		String allEUsers= "Select Username from EndUser";
 		ResultSet Eusers= st.executeQuery(allEUsers);
 		int ind=0;
 		while(Eusers.next())
 		{   
 			
 			String name= Eusers.getString("Username");
 			boolean checkFriend= isFriend(name,uname);
 			
 			if(checkFriend==true)
 			{   
 				//System.out.println(name);
 				frnds[ind]=name;
 				System.out.println("dbfrnds "+ frnds[ind]);
 				
 				ind++;
 				//coun++;
 			}
 		}
 		
 		return frnds;
		
		
	}
	
	/*
	 * Returns true if two Users are friends given their Usernames
	 */
	public boolean  isFriend(String user1,String user2) throws ClassNotFoundException, SQLException
	{
		Connect();
		Statement st=con.createStatement();
		String checkFriends="Select * from Friendship where ( ((Requester_Username='"+user1+"' AND Requested_Username='"+user2+"' ) OR "
				+ "(Requester_Username='"+user2+"' AND Requested_Username='"+user1+"')) AND WhenConfirmed is not NULL AND WhenUnfriended is NULL)";
		ResultSet rs=st.executeQuery(checkFriends);
		int size=0;
		while(rs.next()) 
		{
			size++;
			
		}
		if(size==0)
			return false;
		else
			return true;
	}

	/*
	 * Unfriends two Users given their Usernames
	 */
	public boolean Unfriend(String uname, String fname) throws SQLException, ClassNotFoundException {
		
		Connect();
		Statement st=con.createStatement();
		String unfriend_query="Update Friendship Set WhenUnfriended='"+current_date+"' where( ((Requester_Username='"+uname+"' AND Requested_Username='"+fname+"') "
     			+ "OR(Requester_Username='"+fname+"' AND Requested_Username='"+uname+"' )) AND WhenConfirmed is not null And WhenUnfriended is null  )  ";
     	
         if(st.execute(unfriend_query));
         return true;
         
		
	}

	/*
	 * Suggests a user with people to be friends with
	 */
	public String[] Suggestions(String uname) throws ClassNotFoundException, SQLException {
		
		String[] suggestions=new String[40];
		Connect();
		Statement st=con.createStatement();
		String suggestion="Select Username from EndUser";
		ResultSet suggestedList =st.executeQuery(suggestion);
		Statement st25=con.createStatement();
		int ind=0;
		while(suggestedList.next())
		{
			String friend=suggestedList.getString("Username");
			String RequestSentOrNot="Select * from Friendship where ( ((Requester_Username='"+uname+"' And Requested_Username='"+friend+"') Or (Requested_Username='"+uname+"' And Requester_Username='"+friend+"')) And WhenRequested is not null And (WhenConfirmed is null And WhenRejected is null))";
			ResultSet SentorNot=st25.executeQuery(RequestSentOrNot);
			int count=0;
			while(SentorNot.next())
			{
				count++;
			}
			boolean friendOrNot=isFriend(uname,friend);
			if(!friend.equals(uname)&& !friendOrNot && count==0 )
				suggestions[ind++]=suggestedList.getString("Username");
				
			//System.out.println(suggestedList.getString("Username"));
		}
		return suggestions;
		
	}

	/*
	 * Creates friendship between 2 users
	 */
	public void sendRequest(Friendship fr) throws ClassNotFoundException, SQLException {
		
		Connect();
		Statement st=con.createStatement();
		String createFriend="Insert into Friendship(Requester_Username,Requested_Username,WhenRequested)values('"+fr.getRequester_Username()+"','"+fr.getRequested_Username()+"','"+current_date+"')";
		st.execute(createFriend);
		System.out.println("Friend Created");
	}

	/*
	 * Shows incoming requests to the User with username given
	 */
	public String[] ShowIncomingRequests(String uname) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String requests[]=new String[40];
		Connect();
		Statement st=con.createStatement();
		String friendrequest="Select Requester_Username from Friendship where Requested_Username='"+uname+"' AND WhenConfirmed is null And WhenRejected is null and WhenWithdrawn is null ";
		ResultSet incomingRequest=st.executeQuery(friendrequest);
		int i=0;
		while(incomingRequest.next())
		{
		requests[i++]=incomingRequest.getString("Requester_Username");	
		}
		return requests;
	}

	/*
	 * Lets a user with Username uname accept requests from User with Username fname
	 */
	public void acceptRequests(String uname,String fname) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();  
		String acceptRequest="update Friendship set WhenConfirmed='"+current_date+"' where Requester_Username= '"+fname+"' AND Requested_Username='"+uname+"'";
		st.execute(acceptRequest);
		System.out.println(fname+"  is now your friend");
		
	}

	/*
	 * Lets a user with Username uname decline requests from User with Username fname
	 */
	public void declineRequests(String uname,String fname) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();  
		String declineRequest="update Friendship set WhenRejected='"+current_date+"' where Requester_Username= '"+fname+"' AND Requested_Username='"+uname+"'";
		st.execute(declineRequest);
		
	}
    /*
       * Shows sent requests to the User with Username uname
      */
	public String[] ShowSentRequests(String uname) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sentrequests[]=new String[40];
		Connect();
		Statement st=con.createStatement();  
		String sentRequestsQuery="Select * From Friendship where Requester_Username='"+uname+"' and WhenConfirmed is null and WhenRejected is null and WhenRequested is not null and WhenWithdrawn is null";
 	    ResultSet sentRequests=st.executeQuery(sentRequestsQuery);
 	    
 	    int count=0;
 	    int ind=0;
 	    while(sentRequests.next())
 	    {
 	    	sentrequests[ind++]= sentRequests.getString("Requested_Username");
 	    	
 	    }
		return sentrequests;
	}

	/*
	 * Lets a user with Username uname withdraw requests from User with Username fname
	 */
	public void WithdrawRequest(String uname, String sentName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();  
		String withdraw_request_query="Update Friendship Set WhenWithdrawn='"+current_date+"' where Requester_Username='"+uname+"' and Requested_Username='"+sentName+"' and WhenConfirmed is null and WhenRejected is null and WhenRequested is not null ";
 	    st.execute(withdraw_request_query);
		
	}
    
	/*
	 * Updates User Type of User with Username uname at lOGIN
	 */
	public void updateUserType(String uname) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Connect();
		Statement st3=con.createStatement();  
		 String fetch_date_query="Select * from EndUser where Username= '"+uname+"' " ;
	     ResultSet fetch_data_rs =st3.executeQuery(fetch_date_query);
	     fetch_data_rs.first();
		 Date creation = fetch_data_rs.getDate("DateCreated");
		
		
		 Date today_date= df.parse(current_date);
		 //Finding number of days between Date of Creation and Current Date
		 long diff= creation.getTime()- today_date.getTime();
		 long days_elapsed= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		 
		 //if user is month older, set status to middle
		 if(Math.abs(days_elapsed)>30&& Math.abs(days_elapsed)<365)
		 {   System.out.println("in here");
			 Statement st5=con.createStatement();  
			 String updateStatusQuery= "Update User Set UserTypeID= "+12+" where Username='"+uname+"'";
			 st5.execute(updateStatusQuery);
		 }
		 //if user is year older set status to old
		 else if (Math.abs(days_elapsed)>365)
		 {
			 Statement st6=con.createStatement();  
			 String updateStatusQuery= "Update User Set UserTypeID= "+13+" where Username='"+uname+"'";
			 st6.execute(updateStatusQuery);
		 }
	
		
	}

	/*
	 * Checks if User has Quitted from System
	 */
	public Boolean checkQuit(String umail) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();  
		Statement st1=con.createStatement();  
		String q="Select Status from User where Email1= '"+umail+"'";
		ResultSet rs = st.executeQuery(q);
		rs.first();
		Boolean mark_quit= rs.getBoolean("Status");
		if(mark_quit==true)
		{
			 String status_query="Update User Set Status="+false+" where Email1='"+umail+"' ";
	            st1.execute(status_query);
		}
		System.out.println("Status" + mark_quit);
		return mark_quit;
		
	}

	/*
	 * Adding Health Data for a User
	 */
	public void AddData(HealthData hd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connect();
		Statement st=con.createStatement(); 
		Statement st1=con.createStatement(); 
		//String query="Select DatumID from Datum";
		String query="Select count(*) from Datum";
		ResultSet rs=st.executeQuery(query);
		rs.first();
		int fc=rs.getInt(1)+1;
		//ResultSet rs=st.executeQuery(query);
		//int id;
		/*if(!rs.next())
		{
			id=1;
		
		}
		else 
		{
			rs.last();
			id=rs.getInt("DatumID");
			id=id+1;
			 
		}*/
		String addStatus="Insert into Datum values("+fc+",'"+hd.getUsername()+"',"+hd.getPropertyID()+","+hd.getValue()+",'"+current_date+"')";
		st.execute(addStatus);
		System.out.println("Status Added");
		
		
	}
	
	/*
	 * Displays all properties related to Health whose data is managed
	 */
	public String[] displayProperty() throws ClassNotFoundException, SQLException
	{ 
		Connect();
		String PropertyList[]=new String[3];
		Statement st= con.createStatement();
		String query="Select PropertyID, Name from Property";
		ResultSet rs=st.executeQuery(query);
		 System.out.println("PropertyID		Name  ");
			while(rs.next()){
			PropertyList[rs.getInt("PropertyID")-1]=rs.getString("Name");
			
			
		}
			
			return PropertyList;
	}
  
	/*
	 * Displays the Health Data of all friends
	 */
	public ArrayList<HealthData> viewFriendsStatus(String uname) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement(); 
		Statement st1=con.createStatement(); 
		Statement st2=con.createStatement(); 
		
		ArrayList<HealthData> arr = new ArrayList<HealthData>();
		
		String allEUsers= "Select Username from EndUser";
 		ResultSet Eusers= st2.executeQuery(allEUsers);
 		int ind=0;
 		
 		while(Eusers.next())
 		{   
 			
 			String name= Eusers.getString("Username");
 			boolean checkFriend= isFriend(name,uname);
 			
 			if(checkFriend==true)
 			{   
 			
		
		String query="Select Username,PropertyID,Value from Datum where Username='"+name+"'";
		 String q="Select * from Property";
   	    ResultSet rs=st.executeQuery(query);
   	     ResultSet r=st1.executeQuery(q);
   	   
			//System.out.println("Result Closed");
   	    while(rs.next()){
   	    	HealthData obj=new HealthData();
   	    	//System.out.println("Result Closed111");
			obj.setUsername(rs.getString("Username"));
			obj.setPropertyID(rs.getInt("PropertyID"));
			//obj.setUsername(rs.getString("Username"));
			obj.setValue(rs.getInt("Value")); 
			      
			       while(r.next())
			     { 
				if(rs.getString("PropertyID").equals(r.getString("PropertyID")))
					obj.setPropertyName(r.getString("Name"));
			         }
			arr.add(obj);
			
   	    }
		
	        }
 		}
 		
 		return arr;
	}

	/*
	 * Function to shut a Forum
	 */
	public void shutForum(String uname, String url) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Connect();
		Statement st = con.createStatement();
		String q ="Set FOREIGN_KEY_CHECKS=0";
		String query="Update Forum set WhenClosed='"+current_date+"',DeletedByModerator_Username='"+uname+"' where URL='"+url+"' and WhenClosed is NULL";
		st.execute(q);
		st.execute(query);
		System.out.println("Forum Shut");
	}

	/*
	 * Function to add a new Post to a Forum
	 */
	public boolean AddPost(Post p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st = con.createStatement();
		
		String q="Select Username,ForumID from Post";	
		ResultSet r=st.executeQuery(q);
		karma++;
		while(r.next())
		{
			if(r.getString(1).equals(p.getUsername()) && r.getInt(2)==p.getForumId())
			{
				System.out.println("You have already posted in the forum.");
				return false;
			}
		}
		String query="Insert into Post values('"+p.getUsername()+"',NOW(),'"+p.getForumId()+"','"+p.getTextEntry()+"','"+p.getPhotoLocation()+"','"+p.getLinkLocation()+"','"+p.getVideoLocation()+"')";
		st.execute(query);
		System.out.println("Posted");
		return true;
		
		
	}

	/*
	 * Funtion to Display all posts of a Forum
	 */
	public ArrayList<Post> displayPosts(int fid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st = con.createStatement();
		String query="Select * from Post where ForumID="+fid+" ";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Post> postsOnForum = new ArrayList<Post>();
		
		 while(rs.next()){
			 Post p = new Post();
			 p.setUsername(rs.getString("Username"));
			 p.setTimeCreated(rs.getString("TimeCreated"));
			 p.setForumId(rs.getInt("ForumID"));
			 p.setTextEntry(rs.getString("TextEntry"));
			 p.setPhotoLocation(rs.getString("PhotoLocation"));
			 p.setLinkLocation(rs.getString("LinkLocation"));
			 p.setVideoLocation(rs.getString("VideoLocation"));
			 postsOnForum.add(p);
			 
		 }
		return postsOnForum;
		
	}
	
	/*
	 * Function to insert comment on various posts
	 */

	public void CommentOnPost(Comment c) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Connect();
		Statement st = con.createStatement();
		String q ="Set FOREIGN_KEY_CHECKS=0";
		karma++;
		String query="Insert into Comment values('"+c.getPostUsername()+"','"+c.getPostTimeCreated()+"','"+c.getCommenter_Username()+"',NOW(),'"+c.getCommentText()+"','"+c.getPhotoLocation()+"','"+c.getLinkLocation()+"','"+c.getVideoLocation()+"')";
		st.execute(q);	
		st.execute(query);
		System.out.println("Commented");
		
		
		
	}

	/*
	 * Funtion that gives rating to various posts
	 */
	public void RateOnPost(Rating r) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connect();
		Statement st = con.createStatement();
		String q ="Set FOREIGN_KEY_CHECKS=0";
		karma++;
		String query="Insert into Rating values('"+r.getPostUsername()+"',NOW(),'"+r.getRaterUsername()+"',"+r.getStars()+")";
		st.execute(q);	
		st.execute(query);	
		System.out.println("Rated");
		
	}
    
	/*
	 * Funtion to get Recent Forum ID
	 */
	public int getRecentFID() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();
		String query="Select ForumID,Topic from Forum";
		ResultSet rs=st.executeQuery(query);
		int id=0;
		if(!rs.next())
		{
			id=1;
		
		
		}
		else 
		{
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getString("Topic"));
			 id=rs.getInt("ForumID");
			 id=id+1;
			 
		}
		System.out.println("Id is "+id);
		return id;
	}
	
	/*
	 * Function to Create a new Forum
	 */

	public boolean createForum(Forum f) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connect();
		Statement st=con.createStatement();
		String q ="Set FOREIGN_KEY_CHECKS=0";
		st.executeQuery(q);
		String query="Insert into Forum(ForumID,Topic,URL,Summary,WhenCreated,CreatedByModerator_Username)values("+f.getForumID()+",'"+f.getTopic()+"','"+f.getForumUrl()+"','"+f.getSummary()+"','"+f.getWhenCreated()+"','"+f.getCreatedBy()+"')";
	    if(st.execute(query))
	    { System.out.println("Forum Created");
	    return true;
	    }
	    else
	    	return false;
	}

	
		
	

	
	
}

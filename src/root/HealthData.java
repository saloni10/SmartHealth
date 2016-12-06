package root;

import java.util.Date;

public class HealthData {
	
	
	private String Username;
	private int PropertyID;
	private String PropertyName;
	private int value;
	private Date whenSaved;
	
	
	
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public int getPropertyID() {
		return PropertyID;
	}
	
	public void setPropertyID(int string) {
		PropertyID = string;
	}
	

	public String getPropertyName() {
		return PropertyName;
	}
	
	public void setPropertyName(String string) {
		PropertyName = string;
	}
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Date getWhenSaved() {
		return whenSaved;
	}
	
	
	public void setWhenSaved(Date whenSaved) {
		this.whenSaved = whenSaved;
	}


	public HealthData(String username, int propertyID,int value) {
		
	
		Username = username;
		PropertyID = propertyID;
		this.value = value;
	}
	public HealthData()
	{
		
	}
	
	
	
	

}

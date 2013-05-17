package pk.edu.pucit.mc.linkifydemo;

public class User {
	
	private String userName;
	private String realName;
	private String designation;
	private String education;
	
	public User(String userName, String realName, String designation, String education) {
		// TODO Auto-generated constructor stub
		this.setUserName(userName);
		this.setRealName(realName);
		this.setDesignation(designation);
		this.setEducation(education);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
}

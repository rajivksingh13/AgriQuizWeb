/**
 * 
 */
package com.rajiv.agri.quiz.bean;

/**
 * @author 172661
 *
 */
public class User {
	
	 private String userID;
	 private String password;
	 private String userType;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}

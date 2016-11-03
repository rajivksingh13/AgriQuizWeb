/**
 * 
 */
package com.rajiv.agri.quiz.bean;

/**
 * @author 172661
 *
 */
public class Student {
	int id;
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	
	public Student(int id, String firstName, String lastName, String emailID,String mobileNo){
	      this.id = id;
	      this.firstName = firstName;		
	      this.lastName = lastName;	
	      this.emailID = emailID;
	      this.mobileNo = mobileNo;
	   }
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	

}

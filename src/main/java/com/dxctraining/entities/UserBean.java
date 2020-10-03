package com.dxctraining.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_login")
public class UserBean {
	
	@Id
	@GeneratedValue
	private int userId;	
	
	@NotEmpty(message = "Please provide a name")
	@Size(min=8 ,max=30)
	private String userName;
	
	@NotEmpty(message = "Please provide a password")  
	private String password;
	
	@NotEmpty(message = "Please provide a phone number")
	
	private String userPhone;
	
	
	@NotEmpty(message = "Please provide an Email")
	@Email
	private String userEmail;
	
	public int getUserId() 
	{
		return userId;              
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() 
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() 
	{
		return "UserBean [userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}
	
	
		
	

}

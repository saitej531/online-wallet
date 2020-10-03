package com.dxctraining.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.dao.IUserDao;
import com.dxctraining.dto.UserBeanDto;
import com.dxctraining.entities.UserBean;
import com.dxctraining.exceptions.InvalidInputException;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserBean addNewUser(UserBean bean) 
	{
		return dao.addNewUser(bean);
	}

	@Override
	public List<UserBean>  userLogin(String userName,String password) 
	{
		return dao.userLogin(userName, password);	
	}

	@Override
	public List<UserBean> getAll() 
	{	
		return dao.getAll();
	}
	
	public boolean validateUserName(String  userName) 
	{	
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if(!userName.matches(regex)) 
		{
			throw new InvalidInputException("Username should contain atleast 8 alphanumeric characters");	
		}
		else
			return true;
	}
		
	public boolean validateUserPassword(String password) 
	{
		String regex="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if(password.matches(regex)) 
		{
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
	}
	
	public boolean validateUserEmail(String email)  
	{
	      String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");
	}
	public boolean validateUserPhoneNo(long phoneNo) 
	{
		String s=Long.toString(phoneNo);
		if(!(s.length()==10 && s.charAt(0)!=0)) 
		{
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;	
	}

	
	
	

	
}

package com.dxctraining.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.entities.UserBean;
import com.dxctraining.exceptions.UserException;
import com.dxctraining.service.IUserService;



@RestController
@CrossOrigin("http://localhost:4200")

public class LoginController {

	@Autowired
	private IUserService service;

	@PostMapping("user/reg")
	public String addUsers(@RequestBody UserBean dto) throws UserException
	{   
		UserBean dto1;
		try
		{
			dto1=service.addNewUser(dto);
		}
		catch(UserException e)
		{
			return e.getMessage();
		}
		return "Hello " +dto1+"Sucessfully Registered";
		
	}

	@GetMapping("/adminlogin/{name}/{password}")   
	
	public String adminLoginDto(@PathVariable String name,@PathVariable String password) throws Exception
	{	
		if(name.equals("UrsulaCorbero")&&password.equals("Tokio"))
			return "Login Sucessful...!";
		else 
			return "Invalid name or password";
	}
		 
	@GetMapping("/userLogin/{name}/{password}")
	public String userLoginDto(@PathVariable String name,@PathVariable String password) throws UserException
	{		
		List<UserBean> dto2;
		try
		{
			System.out.println(name);
			String regexUsername="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
			String regexPassword="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
			if(name==null && password==null)
				throw new UserException("Username or password cannot be null");
			if(name.matches(regexUsername))
				throw new UserException("Invalid Username input");
			if(password.matches(regexPassword))
				throw new UserException("Invalid Password input");
			dto2= service.userLogin(name, password);	
		}
		
		catch(UserException e)
		{
			return e.getMessage();
		}
		boolean flag=false;
		for(UserBean userbean: dto2) 
		{
			if(userbean.getUserName().equals(name.trim())&&userbean.getPassword().equals(password.trim())) 
			{
				flag=true;
				break;
			}
		}
		
		if(flag==true)
		{
			return("Login Sucessfully......!!!");
		}
		
		return "Invalid name or password! Try Again...! If not a user please Register.";
	}
	
	@GetMapping("user/findall")    
	public List<UserBean> getall() 
	{
		List<UserBean> dtos = service.getAll();
		return dtos;
	}	
}

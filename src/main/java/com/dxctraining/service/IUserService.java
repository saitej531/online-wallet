package com.dxctraining.service;

import java.util.List;

import com.dxctraining.entities.UserBean;

public interface IUserService {

	public UserBean addNewUser(UserBean bean);
	public List<UserBean> userLogin(String name, String password);
	
	public List<UserBean> getAll();
	

}

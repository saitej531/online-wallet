package com.dxctraining.dao;

import java.util.List;

import com.dxctraining.entities.UserBean;

public interface IUserDao {
	
	public UserBean addNewUser(UserBean bean);
	public List<UserBean> userLogin(String name, String password);
	public List<UserBean> getAll();

}

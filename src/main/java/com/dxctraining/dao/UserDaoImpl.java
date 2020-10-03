package com.dxctraining.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.entities.UserBean;
@Repository
public class UserDaoImpl implements IUserDao{

	@PersistenceContext
	private EntityManager entityManager; 
		
	@Override
	public UserBean addNewUser(UserBean bean) 
	{
		entityManager.merge(bean); 
		return bean;
	}
	
	@Override
	public List<UserBean> userLogin(String name,String password) 
	{
		TypedQuery<UserBean> query=entityManager.createQuery(" from UserBean", UserBean.class);	
		return query.getResultList();
	}

	@Override
	public List<UserBean> getAll() 
	{
		TypedQuery<UserBean> query = entityManager.createQuery("from UserBean", UserBean.class);
		return query.getResultList();
	}

	

}

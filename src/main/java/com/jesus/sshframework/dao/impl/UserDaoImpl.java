package com.jesus.sshframework.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jesus.sshframework.dao.IUserDao;
import com.jesus.sshframework.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements IUserDao{

	public boolean isExistByUsername(String username) {
		String hql = "from Admin admin where lower(admin.username) = lower(?)";
		User admin = (User) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}
	
	//判断
	@Override
	public String save(User user) {
		return super.save(user);	
	}
	
	@Override
	public User get(String id) {
		return super.get(id);
	}
	
	@Override
	public List<User> getAll() {
		return super.getAll();
	}
	
	@Override
	public void delete(String id) {
		super.delete(id);
	}
	
	@Override
	public long getCount() {
		return super.getCount();
	}
}

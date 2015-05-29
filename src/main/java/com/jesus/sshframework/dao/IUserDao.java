package com.jesus.sshframework.dao;

import com.jesus.sshframework.model.User;

public interface IUserDao extends IBaseDao<User, String>{

	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 */
	public boolean isExistByUsername(String username);
}

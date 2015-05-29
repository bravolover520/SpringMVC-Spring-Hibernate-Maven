package com.jesus.sshframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="user")
public class User extends BaseEntity {
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public User() {
		super();
	}
	
	/**
	 * 简单admin对象
	 * @param username 账号
	 * @param password 密码
	 * @param isAccountEnabled 是否启用
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Column(updatable = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package com.platform.base.common.shiro;

import java.io.Serializable;

public class ShiroUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246143430235381800L;
	private long id;
	private String username;
	private String password;
	private String userType;
	private String nick;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}

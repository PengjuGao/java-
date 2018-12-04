package com.platform.base.common.shiro;

import java.util.Set;

public interface ShiroService {
	
	
	/**
	 * shiro认证的时候需要对比用户名和密码（该方法目的是脱离app包，为了直接使用框架）
	 * @param username
	 * @param password
	 * @return
	 */
	public ShiroUser getUserInfo(String username,String password);
	
	
	/**
	 * shiro授权的时候通过名字查询角色集合
	 * @param username
	 * @return
	 */
	public Set<String> getUserRoleSet(String username);
	
	
	/**shiro授权的时候通过名字查询权限集合
	 * @param username
	 * @return
	 */
	public Set<String> getUserPermissionSet(String username);

}

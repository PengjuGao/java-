package com.platform.base.common.shiro;
import com.platform.base.web.SpringHolder;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Date;
import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm{
	
	private Logger logger = Logger.getLogger(MyShiroRealm.class);
	
	//shiro 授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection prinCon) {
		
		System.out.println("##################进入此(授权)方法，时间是[doGetAuthorizationInfo]"+new Date().toLocaleString());
		
		
		ShiroService shiroServiceImpl =(ShiroService)SpringHolder.getBean("shiroServiceImpl");
		
		ShiroUser user = (ShiroUser)prinCon.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		if(null != user){

			Set<String> roleSet = shiroServiceImpl.getUserRoleSet(user.getUsername());

			Set<String> permissionSet = shiroServiceImpl.getUserPermissionSet(user.getUsername());

			info.setRoles(roleSet);

			info.setStringPermissions(permissionSet);
			
			logger.info("授权动作成功。。。");
		}else{
			
			logger.info("授权规则shirouser 对象为null，请调试");
		}
		
		return info;
	}

	//shiro 认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		System.out.println("---------------------进入此（认证）方法，时间是[doGetAuthenticationInfo]"+new Date().toLocaleString());
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		String username = token.getUsername();
		String password = String.valueOf(token.getPassword());
		//TODO:md5 加密password
		ShiroService shiroServiceImpl =(ShiroService)SpringHolder.getBean("shiroServiceImpl");
		ShiroUser shiroUser = shiroServiceImpl.getUserInfo(username, password);
		
		System.out.println("===============shiro getName funcion value is"+this.getName());
		
		if(null != shiroUser){
			
			return new SimpleAuthenticationInfo(shiroUser,password,this.getName());
		}
		
		return null;
	}

}

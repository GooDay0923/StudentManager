package com.gooday.service.shiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooday.model.admin.Admin;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IAdminService;
import com.gooday.service.sys.IResourceService;



public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IAdminService adminService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        Set<String> permissions = adminService.getAdminPermissions(username);
        
        Set<String> roles = adminService.getAdminRole(username);
        
  		authorizationInfo.setRoles(roles);
  		authorizationInfo.setStringPermissions(permissions);
  		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  
		String password = new String((char[]) token.getCredentials());
		
		Admin admin  = adminService.getAdminByUsername(username);
		
		if(admin == null){
			throw new UnknownAccountException();//没找到帐号  
		}
		
		if(Boolean.FALSE.equals(admin.getEnable())) {  
            throw new LockedAccountException(); //帐号锁定  
        }
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
	                admin.getUsername(), //用户名  
	                admin.getPassword(), //密码  
	                ByteSource.Util.bytes(admin.getCredentialsSalt(password)),//salt=username+salt+password
	                getName()  //realm name  
	   );  
		
		return authenticationInfo;
	}	

}

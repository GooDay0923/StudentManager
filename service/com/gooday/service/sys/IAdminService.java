package com.gooday.service.sys;

import java.util.Set;

import com.gooday.model.admin.Admin;

public interface IAdminService {

	public Admin getAdminByUsernameAndPassword(Admin admin);
	
	public Admin getAdminByUsername(String username);
	
	public Integer saveAdmin(Admin admin) throws Exception;
	
	public Set<String> getAdminRole(String username);
	
	public Set<String> getAdminPermissions(String username);
	
}

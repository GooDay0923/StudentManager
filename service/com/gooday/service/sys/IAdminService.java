package com.gooday.service.sys;

import java.util.List;
import java.util.Set;

import com.gooday.model.admin.Admin;

public interface IAdminService {

	public Admin getAdminByUsernameAndPassword(Admin admin);
	
	public Admin getAdminByUsername(String username);
	
	public Integer saveAdmin(Admin admin) throws Exception;
	
	public Set<String> getAdminRole(String username);
	
	public Set<String> getAdminPermissions(String username);
	
	public List<Admin> listAdminByUserName(String username, int page, int rows);
	
	public Admin getAdminById(Long id);
	
	public Integer updateAdmin(Admin admin);
	
}

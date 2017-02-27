package com.gooday.service.sys;

import com.gooday.model.admin.Admin;
import com.gooday.model.admin.AdminRoleMap;

public interface IAdminService {

	public Admin getAdminByUsernameAndPassword(Admin admin);
	
	public Admin getAdminByUsername(String username);
	
	public Integer saveAdmin(Admin admin) throws Exception;
	
	public AdminRoleMap getAdminRoleMapById(Long id);
	
	public void saveAdminRoleMap(AdminRoleMap adminRoleMap);
	
}

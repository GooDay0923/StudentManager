package com.gooday.service.auth;

import com.gooday.model.admin.Admin;

public interface IAdminService {

	public Admin getAdminByUsernameAndPassword(String username, String password);
	
	public Admin getAdminByUsername(String username);
	
	public Integer saveAdmin(Admin admin) throws Exception;
	
}

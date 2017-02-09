package com.gooday.service.auth;

import com.gooday.model.admin.Admin;

public interface IAuthService {

	public Admin getAdminByUserNameAndPassword(String username, String password);
	
}

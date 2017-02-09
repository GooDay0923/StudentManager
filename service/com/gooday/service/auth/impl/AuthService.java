package com.gooday.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.admin.AdminMapper;
import com.gooday.model.admin.Admin;
import com.gooday.service.auth.IAuthService;

@Service
public class AuthService implements IAuthService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin getAdminByUserNameAndPassword(String username, String password) {
//		return adminMapper.selectByUsernameAndPassword(username, password);
		return null;
	}

}

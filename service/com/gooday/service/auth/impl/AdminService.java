package com.gooday.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.admin.AdminMapper;
import com.gooday.model.admin.Admin;
import com.gooday.service.auth.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin getAdminByUsernameAndPassword(String username, String password) {
		return adminMapper.selectByUsernameAndPassword(username, password);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

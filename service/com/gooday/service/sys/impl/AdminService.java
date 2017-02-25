package com.gooday.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.admin.AdminMapper;
import com.gooday.model.admin.Admin;
import com.gooday.service.shiro.PasswordHelper;
import com.gooday.service.sys.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private PasswordHelper passwordHelper;
	
	@Override
	public Admin getAdminByUsernameAndPassword(Admin admin) {
		
		String password = passwordHelper.getEncryptPassword(admin);
		return adminMapper.selectByUsernameAndPassword(admin.getUsername(), password);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		return adminMapper.selectByUsername(username);
	}
	
	private void checkUsername(String username) throws Exception{
		Admin admin = getAdminByUsername(username);
		if(admin != null){
			throw new Exception("用户名已存在");
		}
	}

	@Override
	public Integer saveAdmin(Admin admin) throws Exception {
		checkUsername(admin.getUsername());
		passwordHelper.encryptPassword(admin);
		return adminMapper.insertSelective(admin);
	}
	
	

}

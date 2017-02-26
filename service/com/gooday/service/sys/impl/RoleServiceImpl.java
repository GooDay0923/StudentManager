package com.gooday.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooday.mapper.role.RoleMapper;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;

public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoleById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

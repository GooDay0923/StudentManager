package com.gooday.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooday.mapper.role.RoleMapper;
import com.gooday.mapper.role.RoleResourceMapMapper;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;

public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleResourceMapMapper roleResourceMapMapper;
	
	@Override
	public Role getRoleById(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveRole(Role role) {
		roleMapper.insertSelective(role);
	}

	@Override
	public void removeRoleById(Long id) {
		roleMapper.deleteByPrimaryKey(id);
	}

}

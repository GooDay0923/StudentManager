package com.gooday.service.sys.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.role.RoleMapper;
import com.gooday.mapper.role.RoleResourceMapMapper;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;

@Service
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
	public Integer saveRole(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public void removeRoleById(Long id) {
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Role> listAllRole() {
		return roleMapper.selectAll();
	}

	@Override
	public List<Role> listRoleByName(String name, int page, int rows) {
		PageHelper.startPage(page, rows);
		return roleMapper.selectAllByName(name);
	}

}

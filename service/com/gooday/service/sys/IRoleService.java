package com.gooday.service.sys;

import java.util.List;

import com.gooday.model.role.Role;

public interface IRoleService {

	public Role getRoleById(Long id);
	
	public Integer saveRole(Role role);
	
	public void removeRoleById(Long id);
	
	public List<Role> listAllRole();

	public List<Role> listRoleByName(String name, int page, int rows);
	
}

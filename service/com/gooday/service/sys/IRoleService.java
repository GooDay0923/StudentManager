package com.gooday.service.sys;

import com.gooday.model.role.Role;

public interface IRoleService {

	public Role getRoleById(Long id);
	
	public void saveRole(Role role);
	
	public void removeRoleById(Long id);
	
}

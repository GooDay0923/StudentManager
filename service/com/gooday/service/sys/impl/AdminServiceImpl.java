package com.gooday.service.sys.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.admin.AdminMapper;
import com.gooday.mapper.resource.ResourceMapper;
import com.gooday.mapper.role.RoleMapper;
import com.gooday.mapper.role.RoleResourceMapMapper;
import com.gooday.model.admin.Admin;
import com.gooday.model.resource.Resource;
import com.gooday.model.role.Role;
import com.gooday.model.role.RoleResourceMap;
import com.gooday.service.shiro.PasswordHelper;
import com.gooday.service.sys.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleResourceMapMapper roleResourceMapMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;
	
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

	@Override
	public Set<String> getUserRole(String username) {
		Admin admin = adminMapper.selectByUsername(username);
		Role role = roleMapper.selectByPrimaryKey(admin.getRoleId());
		Set<String> roleName = new HashSet<String>();
		roleName.add(role.getName());
		return roleName;
	}

	@Override
	public Set<String> getUserPermissions(String username) {
		Admin admin = adminMapper.selectByUsername(username);
		Set<String> permissionNames = new HashSet<String>();
		
		if(admin == null){
			return permissionNames;
		}
		
		List<Resource> resourceList = null;
		
		if(admin.getRoleId() != 1L){
			resourceList = resourceMapper.selectByRoleIdAndType(admin.getRoleId(), Resource.TYPE_BUTTON);
		} else {
			resourceList = resourceMapper.selectByType(Resource.TYPE_BUTTON);
		}
		
		for(Resource resource : resourceList){
			if(!StringUtils.isEmpty(resource.getPermission())){
				permissionNames.add(resource.getPermission());
			}
		}
		
		return permissionNames;
	}

	
	

}

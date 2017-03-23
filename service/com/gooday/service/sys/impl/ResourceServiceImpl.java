package com.gooday.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.common.model.TreeNode;
import com.gooday.mapper.resource.ResourceMapper;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IResourceService;

@Service
public class ResourceServiceImpl implements IResourceService{

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public Resource getResourceById(Long id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void SaveResource(Resource resource) {
		resourceMapper.insertSelective(resource);
	}

	@Override
	public void UpdateResourceById(Resource resource) {
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public List<TreeNode> listAdminResource(Set<String> permissions) {
		List<TreeNode> menus = new ArrayList<TreeNode>();
		
		List<Resource> resourceList = resourceMapper.selectByPId(0L);
		for(Resource resource : resourceList){
			
			//如果不是目录，则跳过
			if(!resource.getType().equals(Resource.TYPE_CATALOG)){
				continue;
			}
			
			//权限判断
			if(!hasPermission(permissions, resource)){
				continue;
			}
			
			TreeNode menu = setChildrMenu(resource);
			
			//递归获取子目录
			setResourceChildren(permissions, menu);
			
			menus.add(menu);
		}
		
		return menus;
	}
	
	private TreeNode setChildrMenu(Resource resource){
		TreeNode treeNode = new TreeNode();
		treeNode.setId(resource.getId().toString());
		treeNode.setName(resource.getName());
		treeNode.setParentId(resource.getpId().toString());
		treeNode.setUrl(resource.getUrl());
		treeNode.setIcon(resource.getIcon());
		
		return treeNode;
	}
	
	private boolean hasPermission(Set<String> permissions, Resource resource) {
		if(StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for(String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(resource.getPermission());
			if(p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}

	private void setResourceChildren(Set<String> permissions, TreeNode menu){
		List<TreeNode> childrenMenu = menu.getChildren();
		List<Resource> childResourceList = resourceMapper.selectByPId(Long.valueOf(menu.getId()));
		
		for(Resource resource : childResourceList){
			//如果不是菜单，则跳过
			if(!resource.getType().equals(Resource.TYPE_MENU)) {
				continue;
			}
			
			//权限判断
			if(!hasPermission(permissions, resource)){
				continue;
			}
			
			TreeNode children = setChildrMenu(resource);
			setResourceChildren(permissions, children);
			childrenMenu.add(children);
		}
	}
	
	@Override
	public void removeResourceById(Long id) {
		resourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Resource> listAllResource() {
		// TODO Auto-generated method stub
		return null;
	}

}

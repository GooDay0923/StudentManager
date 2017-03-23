package com.gooday.service.sys;

import java.util.List;
import java.util.Set;

import com.gooday.common.model.TreeNode;
import com.gooday.model.resource.Resource;

public interface IResourceService {

	public Resource getResourceById(Long id);
	
	public void SaveResource(Resource resource);
	
	public void UpdateResourceById(Resource resource);
	
	public List<TreeNode> listAdminResource(Set<String> permissions);
	
	public void removeResourceById(Long id);
	
	public List<Resource> listAllResource();
	
}

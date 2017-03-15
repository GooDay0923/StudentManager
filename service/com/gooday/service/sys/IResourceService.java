package com.gooday.service.sys;

import java.util.List;

import com.gooday.model.resource.Resource;

public interface IResourceService {

	public Resource getResourceById(Long id);
	
	public void SaveResource(Resource resource);
	
	public void UpdateResourceById(Resource resource);
	
	public List<Resource> listUserResource(Long adminId);
	
	public void removeResourceById(Long id);
	
	public List<Resource> listAllResource();
	
}

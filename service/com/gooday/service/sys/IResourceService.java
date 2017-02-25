package com.gooday.service.sys;

import java.util.List;

import com.gooday.model.resource.Resource;

public interface IResourceService {

	public Resource getResourceById(Integer id);
	
	public void SaveResource(Resource resource);
	
	public void UpdateResourceById(Resource resource);
	
	public List<Resource> listByPId(Integer pId);
	
	public List<Resource> listUserResource(Long adminId);
	
	public void removeResourceById(Long id);
	
}

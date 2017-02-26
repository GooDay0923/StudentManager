package com.gooday.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooday.mapper.resource.ResourceMapper;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IResourceService;

@Service
public class ResourceServiceImpl implements IResourceService{

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public Resource getResourceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveResource(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateResourceById(Resource resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> listByPId(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> listUserResource(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeResourceById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

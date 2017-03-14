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
	public List<Resource> listUserResource(Long adminId) {
		
		return null;
	}

	@Override
	public void removeResourceById(Long id) {
		resourceMapper.deleteByPrimaryKey(id);
	}

}

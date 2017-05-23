package com.gooday.mapper.resource;

import java.util.List;

import com.gooday.model.resource.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> selectByRoleIdAndType(Long roleId, Short type);
    
    List<Resource> selectByType(Short type);
    
    List<Resource> selectByPId(Long pId);

    List<Resource> selectAllMenus();
    
}
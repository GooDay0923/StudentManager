package com.gooday.mapper.role;

import com.gooday.model.role.RoleResourceMap;

public interface RoleResourceMapMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceMap record);

    int insertSelective(RoleResourceMap record);

    RoleResourceMap selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceMap record);

    int updateByPrimaryKey(RoleResourceMap record);
}
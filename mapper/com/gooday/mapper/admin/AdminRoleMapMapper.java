package com.gooday.mapper.admin;

import com.gooday.model.admin.AdminRoleMap;

public interface AdminRoleMapMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminRoleMap record);

    int insertSelective(AdminRoleMap record);

    AdminRoleMap selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRoleMap record);

    int updateByPrimaryKey(AdminRoleMap record);
}
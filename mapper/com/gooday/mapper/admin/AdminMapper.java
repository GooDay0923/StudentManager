package com.gooday.mapper.admin;

import org.apache.ibatis.annotations.Param;

import com.gooday.model.admin.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
    
    Admin selectByUsername(@Param("username")String username);
    
}
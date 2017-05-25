package com.gooday.mapper.role;

import java.util.List;

import com.gooday.model.role.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAll();

    List<Role> selectAllByName(@Param("name")String name);

}
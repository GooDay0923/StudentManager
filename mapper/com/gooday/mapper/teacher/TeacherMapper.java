package com.gooday.mapper.teacher;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gooday.model.teacher.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}
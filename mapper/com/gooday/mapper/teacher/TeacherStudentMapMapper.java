package com.gooday.mapper.teacher;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gooday.model.teacher.TeacherStudentMap;


public interface TeacherStudentMapMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeacherStudentMap record);

    int insertSelective(TeacherStudentMap record);

    TeacherStudentMap selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeacherStudentMap record);

    int updateByPrimaryKey(TeacherStudentMap record);
}
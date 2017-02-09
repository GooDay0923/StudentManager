package com.gooday.mapper.student;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gooday.model.student.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
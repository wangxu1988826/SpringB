package com.wangxu.serverdemo.mapper;

import com.wangxu.serverdemo.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student selectByPrimaryKey(Integer id);
}

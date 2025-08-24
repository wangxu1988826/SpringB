package com.wangxu.learnsboot.mapper;

import com.wangxu.learnsboot.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student selectByPrimaryKey(Integer id);
}

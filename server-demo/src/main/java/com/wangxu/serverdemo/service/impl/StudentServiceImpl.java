package com.wangxu.serverdemo.service.impl;

import com.wangxu.serverdemo.mapper.StudentMapper;
import com.wangxu.serverdemo.model.Student;
import com.wangxu.serverdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}

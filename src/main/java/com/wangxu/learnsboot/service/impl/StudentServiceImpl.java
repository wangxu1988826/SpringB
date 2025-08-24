package com.wangxu.learnsboot.service.impl;

import com.wangxu.learnsboot.mapper.StudentMapper;
import com.wangxu.learnsboot.model.Student;
import com.wangxu.learnsboot.service.StudentService;
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

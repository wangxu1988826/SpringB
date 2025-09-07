package com.wangxu.serverdemo.service;

import com.wangxu.serverdemo.model.Student;

public interface StudentService {
    /**
     * 根据学生标识获取学生详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}

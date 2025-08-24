package com.wangxu.learnsboot.web;

import com.wangxu.learnsboot.model.Student;
import com.wangxu.learnsboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    /*http://localhost:8080/student/detail?id=1这样 SpringMVC 会把 id=1 绑定到 Integer id 参数上
    * 如果你希望 URL 更直观，可以用 @PathVariable
    *   @GetMapping("/student/detail/{id}")
        @ResponseBody
        public Object getStudent(@PathVariable("id") Integer id)*/
    @RequestMapping(value = "/student/detail")
    public @ResponseBody Object getStudent(Integer id){
//        Student student = studentService.queryStudentById(id);
        return studentService.queryStudentById(id);
    }
}

package com.wangxu.serverdemo.web;

import com.wangxu.serverdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 想想和  @RestController的区别，下面为什么用@ResponseBody？
 * @Controller 用来做 页面跳转。返回值默认会被当成视图名，比如返回 "hello"，Spring 会去找 templates/hello.html 或者 JSP 页面。
 */
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

//    @RequestMapping("/say")
//    @ResponseBody
//    public String sayHello(){
//        return "hello world";
//    }
}

package com.wangxu.serverdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/say/{name}")
    public  String SayHello( @PathVariable String name ) {
        return  "Hello "+ name + "!";
    }
}

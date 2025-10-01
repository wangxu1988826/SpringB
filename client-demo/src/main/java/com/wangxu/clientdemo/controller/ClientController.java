package com.wangxu.clientdemo.controller;

import com.wangxu.clientdemo.api.HelloClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final HelloClient helloClient;
    public ClientController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @GetMapping("/say/{name}")
    public String getStudent(@PathVariable("name") String name){
        return helloClient.SayHello(name);
    }
}




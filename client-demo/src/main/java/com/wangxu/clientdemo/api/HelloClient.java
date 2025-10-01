package com.wangxu.clientdemo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "server-demo")// 指向 server-demo 服务
public interface HelloClient {
    @GetMapping("/say/{name}")
    String SayHello(@PathVariable("name") String name);
}

package com.wangxu.serverdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RedisDemoController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/redis/set")
    public String setKey(){
        redisTemplate.opsForValue().set("spring:hello","world");
        return "success";
    }

    @GetMapping("redis/get")
    public String getKey(){
        return redisTemplate.opsForValue().get("spring:hello");
    }

    //使用请求参数（推荐，直观）
    //http://localhost:8080/redis/set?key=testKey&value=hello
    //http://localhost:8080/redis/get?key=testKey
    @GetMapping("/redis/set1")
    public String setKey1(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Set success: " + key + " = " + value;
    }

    @GetMapping("/redis/get1")
    public String getKey1(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }


    //使用路径参数（RESTful 风格）
    //http://localhost:8080/redis/set/testKey/hello
    //http://localhost:8080/redis/get/testKey
    @GetMapping("/redis/set/{key}/{value}")
    public String setKey(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Set success: " + key + " = " + value;
    }

    @GetMapping("/redis/get/{key}")
    public String getKey(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }


    //使用 POST + JSON（更适合复杂数据）
    /**请求示例（用 Postman 或 curl）
     * POST http://localhost:8080/redis/set
     * {
     *   "key": "testKey",
     *   "value": "hello"
     * }
     *
     * @param data
     * @return
     */
    @PostMapping("/redis/set")
    public String setKey(@RequestBody Map<String, String> data) {
        String key = data.get("key");
        String value = data.get("value");
        redisTemplate.opsForValue().set(key, value);
        return "Set success: " + key + " = " + value;
    }



}

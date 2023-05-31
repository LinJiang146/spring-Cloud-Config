package org.example.controller;


import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/provider")
public class UserController {


    @Value("${port}")
    private String aaa;

    @GetMapping("/test")
    public String test(){
        System.out.println(aaa);
        return aaa;
    }

    @GetMapping("/helloA")
    public String HelloA(){
        System.out.println("helloB");
        return "Hello World A";
    }
    @GetMapping("/helloB")
    public String HelloB(){
        System.out.println("helloB");
        return "Hello World B";
    }
}

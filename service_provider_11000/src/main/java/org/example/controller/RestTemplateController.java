package org.example.controller;
import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @GetMapping("get")
    public String get() {
        System.out.println("RestTemplate调用get方法成功");
        return "RestTemplate调用get方法成功";
    }

    @PostMapping("post")
    public String post() {
        System.out.println("RestTemplate调用post方法成功");
        return "RestTemplate调用post方法成功";
    }

    @PutMapping("put")
    public String put() {
        System.out.println("RestTemplate调用put方法成功");
        return "RestTemplate调用put方法成功";
    }

    @DeleteMapping("delete")
    public String delete() {
        System.out.println("RestTemplate调用delete方法成功");
        return "RestTemplate调用delete方法成功";
    }
}

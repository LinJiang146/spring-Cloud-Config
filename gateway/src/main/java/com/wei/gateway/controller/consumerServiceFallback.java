package com.wei.gateway.controller;



import com.wei.gateway.entity.CommonResult;
import com.wei.gateway.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class consumerServiceFallback {
    @RequestMapping(value = "/fallback",method = RequestMethod.GET)
    public CommonResult getCommonResult(){
        return new CommonResult<>(403,"服务异常进行服务降级响应",new User());
    }
}

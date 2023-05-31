package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.feign.UserFeignService;

import org.springframework.cloud.client.ServiceInstance;
import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("customer")
//@LoadBalancerClient(name="provider-server",configuration = CustomlLoadBalancedConffiguration.class )
public class CartController {
    @Autowired
    private UserFeignService userFeignService;


    @GetMapping("/helloA")
    @RateLimiter(name = "ratelimiterA",fallbackMethod = "fallbackHello")
//    @Bulkhead(name = "bulkheadA",fallbackMethod = "fallbackHello")
//    @CircuitBreaker(name = "backendA",fallbackMethod = "fallbackHello")
    public String helloA(){

        Random random = new Random();
//        int i = random.nextInt(0, 10);
//        System.out.println(i);
//        if (i<5) throw new RuntimeException();

        return userFeignService.HelloA();
    }
    @GetMapping("/helloB")
    @RateLimiter(name = "ratelimiterA",fallbackMethod = "fallbackHello")
//    @Bulkhead(name = "bulkheadB",fallbackMethod = "fallbackHello")
//    @CircuitBreaker(name = "backendB",fallbackMethod = "fallbackHello")
    public String helloB(){
        return userFeignService.HelloB();
    }
    //    public CompletableFuture<User> addCart(@PathVariable Integer userId) throws InterruptedException{
//        System.out.println("jinru");
////        Thread.sleep(10000L);//阻塞10秒
//        CompletableFuture<User> result = CompletableFuture.supplyAsync(()->{
//            return userFeignService.getUserById(userId).getResult();
//        });
//        System.out.println("likai");
//        return result;
//    }
    public CommonResult<User> fallback(Integer userId,Throwable e){
        e.printStackTrace();
        System.out.println("fallback已经调用");
        CommonResult<User> result = new CommonResult<>(400,"fallback",new User());
        return result;
    }
}

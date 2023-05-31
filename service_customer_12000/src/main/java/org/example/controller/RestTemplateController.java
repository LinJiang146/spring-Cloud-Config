package org.example.controller;
import org.example.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("get")
    public String get() {
        return restTemplateService.get();
    }

    @PostMapping("post")
    public String post() {
        return restTemplateService.post();
    }

    @PutMapping("put")
    public void put() {
        restTemplateService.put();
    }

    @DeleteMapping("delete")
    public void delete() {
        restTemplateService.delete();
    }
}

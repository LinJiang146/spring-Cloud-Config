package org.example.service.impl;

import org.example.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String get() {
        String forObject = restTemplate.getForObject("http://localhost:11000/restTemplate/get", String.class);
        System.out.println(forObject);
        return forObject;
    }

    @Override
    public String post() {
        String forObject = restTemplate.postForObject("http://localhost:11000/restTemplate/post",null,String.class);
        System.out.println(forObject);
        return forObject;
    }

    @Override
    public void put() {
        restTemplate.put("http://localhost:11000/restTemplate/put",null);
    }

    @Override
    public void delete() {
        restTemplate.delete("http://localhost:11000/restTemplate/delete");
    }
}

package com.example.cloud.movie_ribbon.controller;

import com.example.cloud.movie_ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liupengfei on 2017/12/30.
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
    }
}

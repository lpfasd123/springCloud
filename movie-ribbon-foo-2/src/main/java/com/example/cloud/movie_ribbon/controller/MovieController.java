package com.example.cloud.movie_ribbon.controller;

import com.example.cloud.movie_ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        //http://localhost:7900/simple/
        //VIP virtual IP 虚拟IP
        //HAProxy Heartbeat
        return restTemplate.getForObject("http://user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("user");
        System.out.println("111 : " + serviceInstance.getHost() + ":" +  serviceInstance.getPort() + ":" + serviceInstance.getServiceId() );


        ServiceInstance serviceInstance2 = loadBalancerClient.choose("user2");
        System.out.println("222 : " + serviceInstance2.getHost()  + ":" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId()  );

        return "1";

    }

}

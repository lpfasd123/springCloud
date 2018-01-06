package com.example.cloud.cloudDemo.controller;

import com.example.cloud.cloudDemo.dao.UserRepository;
import com.example.cloud.cloudDemo.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liupengfei on 2017/12/30.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/eureka-instance1")
    public ServiceInstance serviceUrl2() {
        ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
        return instance;
    }
    @GetMapping("/eureka-instance2")
    public String serviceUrl3() {
        List<ServiceInstance> list = discoveryClient.getInstances("user");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("user", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return this.userRepository.findOne(id);
    }
}

package com.example.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liupengfei on 2018/1/6.
 * Description: 定制ribbon的负载均衡规则
 */
@Configuration
public class RibbonFooConfig {
    @Autowired
    IClientConfig config;
    @Bean
    public IRule ribbonRule(IClientConfig config) {
            return new RandomRule();
        }
}

package com.nikanorov.rest.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.nikanorov.rest")
public class Congigg {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

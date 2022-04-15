package com.example.demo;


import com.example.demo.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean("cache")
    Cache cache(){
        return new Cache();
    }

}

package com.example.demo;


import com.example.demo.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.cache")
@ComponentScan("com.example.demo.counter")
public class SpringConfig {


}

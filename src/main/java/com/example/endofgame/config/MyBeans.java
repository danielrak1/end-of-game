package com.example.endofgame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class MyBeans {

    @Bean
    public ExecutorService threadsPool(){
        return Executors.newFixedThreadPool(4);
    }
}

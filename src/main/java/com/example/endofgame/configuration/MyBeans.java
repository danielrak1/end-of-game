package com.example.endofgame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class MyBeans {

    @Bean
    public ExecutorService workers() {
        return Executors.newFixedThreadPool(4);
    }
}

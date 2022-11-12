package com.example.typeexcludefilter.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class A {


    @Bean
    public String aaa(){
        return "aaa";
    }
}


package com.example.importandcondition.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StringConfig {

    @Bean
    public String sss(){
        return "sss";
    }
}
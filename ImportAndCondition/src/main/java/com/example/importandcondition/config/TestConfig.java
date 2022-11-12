package com.example.importandcondition.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@ConditionalOnMissingBean(String.class)
@Configuration
public class TestConfig {

    @Bean
    public String aaa(){
        return "aaa";
    }
}

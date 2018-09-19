package com.windy.javacode.config;


import com.windy.javacode.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigoOfPropertValues {

    @Bean
    public Person person(){
        return new Person();
    }

}

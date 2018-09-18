package com.windy.javacode;


import com.windy.javacode.config.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@ComponentScan(basePackages = "com.windy")
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        SpringApplication.run(Application.class, args);
    }

}

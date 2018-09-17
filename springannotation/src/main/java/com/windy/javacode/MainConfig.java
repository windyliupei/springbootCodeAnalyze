package com.windy.javacode;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类==配置文件
@Configuration
public class MainConfig {

    //和xml中的bean标签一样，方法名为ID
    @Bean(value = "person01")
    public Person person(){
        return new Person("lisi",20);
    }

}

package com.windy.javacode.config;


import com.windy.javacode.beans.Person;
import com.windy.javacode.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//配置类==配置文件
@Configuration

//使用excludeFilters/includeFilters必须useDefaultFilters为false，才生效


//FilterType.ANNOTATION
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,value = {Controller.class})
//})

//FilterType.ASSIGNABLE_TYPE:指定的类（包含其子类）
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value = {BookService.class})
//})


//自定义规则
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,includeFilters = {
//        @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MyTypeFilter.class})
//})



@ComponentScan(value = "com.windy.javacode")
public class MainConfig {

    //和xml中的bean标签一样，方法名为ID
    @Bean(value = "person01")
    public Person person(){
        return new Person("lisi",20);
    }

}

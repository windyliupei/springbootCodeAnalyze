package com.windy.javacode.config;


import com.windy.javacode.dao.BookDao;
import com.windy.javacode.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Action;


/*
* */

@Configuration
@ComponentScan(value = "com.windy.javacode")
public class MyConfigAutowired {





   /* @Bean("bookDao3")
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("3");

        return bookDao;
    }*/

}

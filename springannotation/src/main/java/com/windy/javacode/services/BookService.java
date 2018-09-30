package com.windy.javacode.services;

import com.windy.javacode.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("bookService")
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public BookService(){
        System.out.println("BookService Construct");
    }

}

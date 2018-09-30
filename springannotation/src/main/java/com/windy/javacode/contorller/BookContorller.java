package com.windy.javacode.contorller;

import com.windy.javacode.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookContorller {


   @Autowired
   BookService bookService;
}

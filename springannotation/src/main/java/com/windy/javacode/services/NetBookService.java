package com.windy.javacode.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("netBookService")
@Service
public class NetBookService extends BookService {
}

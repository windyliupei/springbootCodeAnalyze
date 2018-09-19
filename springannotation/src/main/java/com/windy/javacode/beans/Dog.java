package com.windy.javacode.beans;

import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements IAnimals{

    //14、生命周期-@PostConstruct&@PreDestroy
    @PostConstruct
    public void init(){

    }
    //14、生命周期-@PostConstruct&@PreDestroy
    @PreDestroy
    public void dispose(){

    }

    @Override
    public void call() {

    }
}

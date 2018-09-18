package com.windy.javacode.config;

import com.windy.javacode.beans.Colour;
import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<Colour> {
    @Override
    public Colour getObject() throws Exception {
        return new Colour();
    }


    @Override
    public Class<?> getObjectType() {
        return Colour.class;
    }

    @Override
    public boolean isSingleton(){
        return false;
    }
}

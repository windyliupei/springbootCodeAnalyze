package com.windy.javacode.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//13、生命周期-InitializingBean和DisposableBean
@Component
@Primary
public class Cat implements InitializingBean, DisposableBean,IAnimals {
    @Override
    public void destroy() throws Exception {
        System.out.print("cat was destory...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("cat was init...");
    }

    @Override
    public void call() {

    }
}

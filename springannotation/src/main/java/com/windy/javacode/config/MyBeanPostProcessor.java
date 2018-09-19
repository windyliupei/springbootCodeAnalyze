package com.windy.javacode.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//15、生命周期-BeanPostProcessor-后置处理器:



//遍历容器中所有的BeanPostProcessor，挨个执行beforeInitialization，
//一旦返回null ，跳出循环遍历，不会执行后面的BeanPostProcessor

//以下方法是在populateBeans方法后执行

//先执行 postProcessBeforeInitialization
//执行初始化方法 Init，例如：PostConstruct
//最后执行postProcessAfterInitialization

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println("postProcessBeforeInitialization...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("postProcessAfterInitialization...");
        return bean;
    }

}

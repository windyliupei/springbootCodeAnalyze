package com.windy.javacode.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //如果容器中含有person这个Bean了，那么也要注册“Bill”这个person的bean
        //参见MainConfig这个类
        /*BeanDefinitionRegistry registry = context.getRegistry();
        boolean containsPerson = registry.containsBeanDefinition("person");
        return containsPerson;*/

        //获取当前Environment
        Environment environment = context.getEnvironment();
        return environment.getProperty("os.name").contains("Windows");
    }
}

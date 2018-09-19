package com.windy.javacode.config.selectors;

import com.windy.javacode.beans.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyDefinationSelector implements ImportBeanDefinitionRegistrar {

    /**
     * importingClassMetadata 当前类的注解信息
     *
     */

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containsColour = registry.containsBeanDefinition("com.windy.javacode.beans.Colour");

        if (containsColour){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }
    }
}

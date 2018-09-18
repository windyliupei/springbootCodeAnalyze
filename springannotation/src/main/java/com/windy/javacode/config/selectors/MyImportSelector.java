package com.windy.javacode.config.selectors;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义需要返回的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是要返回的类的全类名数组
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        String[] beans = new String[1];
        beans[0] = "com.windy.javacode.beans.Red";

        return beans;
    }
}

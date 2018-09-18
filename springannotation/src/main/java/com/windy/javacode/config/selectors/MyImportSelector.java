package com.windy.javacode.config.selectors;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义需要返回的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是要返回的类的全类名数组
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        String[] beans = new String[0];
        beans[0] = "com.windy.javacode.beans.Red";

        return beans;
    }
}

package com.windy.javacode.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {


    //metadataReader:读取到的当前类的信息
    //metadataReaderFactory：可以获取到其他任何类的信息
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源
        Resource resource = metadataReader.getResource();

        if (classMetadata.getClassName().contains("Book")){
            return true;
        }


        return false;
    }
}

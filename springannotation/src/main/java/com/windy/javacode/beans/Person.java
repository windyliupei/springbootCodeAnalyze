package com.windy.javacode.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Windy
 */
public class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //使用@value赋值
    //1。基本数据类型
    //2。可以写SpEL（Spring，表达式#{}）
    //3。可以写${}取出配置文件的值


    @Value("2")
    private Integer age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

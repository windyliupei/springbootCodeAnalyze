package com.windy.javacode.test;


import com.windy.javacode.config.MainConfig;
import com.windy.javacode.beans.Person;
import com.windy.javacode.contorller.BookContorller;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    BookContorller contorller;
    /*
    使用配置文件
    * */
    @Test
    public void mainXmlConfigTest(){

        //Arrange
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("person");

        //Action
        System.out.print(bean);

        //Assert
        Assert.assertTrue(bean.getName().equals("zhangsan"));

    }

    @Test
    public void AnnotationConfig(){

        //Arrange

        //Action
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);

        //Assert
        Assert.assertTrue(person.getName().equals("lisi"));

    }

    @Test
    public void getBeansNames(){
        //Arrange

        //Action
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        //值为person，如果改名字的话，去改@Bean avlue
        System.out.print(beanNamesForType);

        //Assert
        Assert.assertTrue(person.getName().equals("lisi"));
    }

    @Test
    public void iocTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        contorller.equals(null);
        Assert.assertTrue(beanDefinitionNames.length>0);
    }
}

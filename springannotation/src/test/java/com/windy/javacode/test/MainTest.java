package com.windy.javacode.test;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.windy.javacode.config.MainConfig;
import com.windy.javacode.beans.Person;
import com.windy.javacode.config.MyConfigAutowired;
import com.windy.javacode.config.MyConfigoOfPropertValues;
import com.windy.javacode.contorller.BookContorller;
import com.windy.javacode.dao.BookDao;
import com.windy.javacode.services.BookService;
import com.windy.javacode.services.NetBookService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainTest {



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

        //更改MainConfig中 @ComponentScan 查看容器中的实例
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        //更改MainConfig中 @Scope查看什么时候创建Person对象
        applicationContext.getBean("person");


        //加上 & 前缀后会获得MyBeanFactory 对象
        Object myBeanFactory = applicationContext.getBean("myBeanFactory");
        Object myBeanFactoryRealName = applicationContext.getBean("&myBeanFactory");

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        Assert.assertTrue(beanDefinitionNames.length>0);
    }

    @Test
    public void iotTest_PropertyValues(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigoOfPropertValues.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();



    }

    //继承关系的Bean,使用Qualifier明确要获得那个Bean
    @Test
    public void iotTest_Autowired1(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigAutowired.class);

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        BookService netBookService = (BookService) applicationContext.getBean("netBookService");

        Assert.assertTrue(bookService!=null&&netBookService!=null);
    }


    @Test
    public void iotTest_Autowired2(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigAutowired.class);

        //在MyConfigAutowired中有@Bean的方式注册了一个Bean Label为 “2”
        //BookDao 自身实例默认为Label为“1”
        //那么看看这个个bookDao是多少
        BookDao bookDao = applicationContext.getBean(BookDao.class);

        System.out.println(bookDao.getLabel());
    }

    private static String key = "hkwinfo1";
    private static String iv = "hkwinfo1";
    @Test
    public void DescEncrypt() throws Exception {
        String testStr = "hello world!";

        String codE = "";
        String codD;

        try {
            codE = encrypt1(testStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(codE.equals("ETwOTWiqC2sfBVs0mmEqTw=="));
        codD = decrypt1(codE);
        Assert.assertTrue(codD.equals(testStr));
    }




    public static String encrypt1(String encryptString)throws Exception
    {
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        return Base64.encode(cipher.doFinal(encryptString.getBytes()));
    }

    public static String decrypt1(String strIn) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);
        return new String(cipher.doFinal(Base64.decode(strIn)));
    }

}

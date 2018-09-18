package com.windy.javacode.config;


import com.windy.javacode.beans.Person;
import com.windy.javacode.config.selectors.MyDefinationSelector;
import com.windy.javacode.config.selectors.MyImportSelector;
import org.springframework.context.annotation.*;

//配置类==配置文件
@Configuration

//使用excludeFilters/includeFilters必须useDefaultFilters为false，才生效


//FilterType.ANNOTATION
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,value = {Controller.class})
//})

//FilterType.ASSIGNABLE_TYPE:指定的类（包含其子类）
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value = {BookService.class})
//})


//自定义规则
//@ComponentScan(value = "com.windy.javacode",useDefaultFilters = false,includeFilters = {
//        @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MyTypeFilter.class})
//})





//要导入到容器中的组件，ID默认是全名
//@Import({Colour.class, Red.class})

//返回需要导入的组件的全类名数组
@Import({MyImportSelector.class, MyDefinationSelector.class})

@ComponentScan(value = "com.windy.javacode")
public class MainConfig {


    //@Scope(value="singleton")
    //@Scope(value = "prototype")
    //默认：singleton


    //@Lazy:创建容器时并不加载Bean，也就是不创建Bean，这个只在@Scope为singleton的时候起作用



    //和xml中的bean标签一样，方法名为ID
    @Bean(value = "person")
    public Person person(){
        System.out.print("开始创建Person对象");
        return new Person("lisi",20);
    }

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",60);
    }

    //配置 VM arguments -Dos.name=linux，模拟在linux下运行
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("Linus",40);
    }

    //这里返回的是一个MyBeanFactory bean，但实际上是产生一个Colour类在容器中，而并不是MyBeanFactory类
    @Bean
    public MyBeanFactory myBeanFactory(){
        return new MyBeanFactory();
    }

}

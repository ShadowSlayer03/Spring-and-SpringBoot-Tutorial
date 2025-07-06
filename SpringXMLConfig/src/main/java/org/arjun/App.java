package org.arjun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Alien obj1 = context.getBean("alien", Alien.class);
        obj1.setAge(22);
        System.out.println(obj1.getAge());
        obj1.code();

        //Alien obj2 = (Alien) context.getBean("alien");
        //System.out.println(obj2.getAge());
        //obj2.code();

//        Computer com = context.getBean(Computer.class);
//
//        Desktop obj = context.getBean("com2",Desktop.class);


    }
}

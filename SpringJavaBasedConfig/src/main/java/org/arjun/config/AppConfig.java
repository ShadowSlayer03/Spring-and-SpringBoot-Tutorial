package org.arjun.config;

import org.arjun.Alien;
import org.arjun.Computer;
import org.arjun.Desktop;
import org.arjun.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
// If we want Spring to manage all the objects, rather than us managing here by Java Objects or XML, use @Component on classes and @ComponentScan on AppConfig
@ComponentScan("org.arjun")
public class AppConfig {

//    @Bean
//    public Alien alien(Computer com){
//        Alien obj = new Alien();
//        obj.setAge(25);
//        obj.setCom(com);
//        return obj;
//    }
//
//    //@Bean(name = {"com2", "desktop1", "Beast"})
//    @Bean
//    // By default, in singleton, if you create many objects of the same bean, then only a single object is created.
//    // But in prototype, different objects are created.
//    @Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    // We can use primary or set the qualifier in case of 2 beans related to same type/interface.
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}

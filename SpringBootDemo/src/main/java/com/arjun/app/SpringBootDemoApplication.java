package com.arjun.app;

import com.arjun.app.Model.Alien;
import com.arjun.app.Model.Laptop;
import com.arjun.app.Service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

        LaptopService service = context.getBean(LaptopService.class);

        Laptop lap = context.getBean(Laptop.class);
        service.addLaptop(lap);
    }

}

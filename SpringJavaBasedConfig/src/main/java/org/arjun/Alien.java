package org.arjun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {

    // If you need to inject a default value from a different file we can use @Value.
    // If we directly assign with '=' then it would be considered hardcoding.
    @Value("21")
    private int age;
    private int salary;

    // Autowired is used so that Spring handles this and Spring also knows about Laptop and Desktop implementing Computer because both are @Component
    @Autowired
    // We can use @Qualifier or mark a specific implementation of Computer here as @Primary to resolve the issue, but @Qualifier has higher priority.
    @Qualifier("desktop")
    private Computer com;

    public Alien() {
        System.out.println("Default Alien Constructor");
    }

    @ConstructorProperties({"age","lap","salary"})
    public Alien(int age, Laptop l,int sal) {
        System.out.println("Parameterized Alien Constructor");
        this.age = age;
        this.com = l;
        this.salary = sal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Alien setter called!");
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void code() {
        System.out.println("I love to code");
        com.compile();
    }
}

package org.arjun;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private int salary;
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

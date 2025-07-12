package org.arjun;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void createStudent() {
        Student s1 = new Student();
        s1.setName("Gaurav");
        s1.setRollNo(4);
        s1.setAge(19);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.arjun.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);

    }

    public static void readStudent() {
        Student s2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.arjun.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        s2 = session.get(Student.class, 2);

        session.close();
        sf.close();

        System.out.println(s2);
    }

    public static void updateStudent() {
        Student s3 = new Student();
        s3.setRollNo(4);
        s3.setName("Rahul");
        s3.setAge(20);

        SessionFactory sf = new Configuration().addAnnotatedClass(org.arjun.Student.class).configure().buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s3);

        transaction.commit();

        session.close();
        sf.close();
    }

    public static void deleteStudent() {
        Student s1 = new Student();

        SessionFactory sf = new Configuration().addAnnotatedClass(org.arjun.Student.class).configure().buildSessionFactory();

        Session session = sf.openSession();

        s1 = session.get(Student.class, 2);

        Transaction transaction = session.beginTransaction();

        session.remove(s1);

        transaction.commit();

        session.close();
        sf.close();
    }

    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("MSI");
        l1.setModel("GF63 Thin");
        l1.setRam(16);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.arjun.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        /* HQL - Hibernate Query Language(Similar to SQL)
        String brand = "MSI";
        int ram = 16;

        Query query = session.createQuery("select brand,model from Laptop where brand like ?1 and ram=?2");
        query.setParameter(1,brand);
        query.setParameter(2,ram);
        List<Object[]> laptops= query.getResultList();

        for(Object[] data: laptops){
            System.out.println((String)data[0] + " " + (String)data[1]);
        }
        */

        /*
        Get - Runs the query even if the results are not used/printed to screen.
        Load - It is deprecated and it doesn't run the query if not using the result anywhere.
        Laptop laptop = session.load(Laptop.class,2);
        System.out.println(laptop);
        */


       /*
        L1 Caching:
        Same query fetching the same data in the same session, query won't run second time.

        L2 Caching:
        - If the same query is being run in different sessions, query won't run second time
        - Need to install jcache and ehcache,caffeine and add annotation @Cacheable.

        Laptop l2 = session.get(Laptop.class,3);
        System.out.println("First laptop call 1: " + l2);

        Laptop l4 = session.get(Laptop.class,3);
        System.out.println("First laptop call 2: " + l4);

        session.close();

        Session session1 = sf.openSession();

        Laptop l3 = session1.get(Laptop.class,3);
        System.out.println("Second laptop: " + l3);

        session1.close();
       */

        sf.close();
    }
}
package com.arjun.SpringDataJPAProject;

import com.arjun.SpringDataJPAProject.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaProjectApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollNo(101);
		s1.setMarks(85);
		s1.setName("Rahul Kumar");

		s2.setRollNo(102);
		s2.setMarks(99);
		s2.setName("Kiran Chopra");

		s3.setRollNo(103);
		s3.setMarks(94);
		s3.setName("Shubham Awasthi");

		// Create
		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		//System.out.println(repo.findById(103));

		// Read
		//System.out.println(repo.findAll());
		// Optional<Student> s = repo.findById(105);
		// System.out.println(s.orElse(new Student()));
		//System.out.println(repo.findByName("Shubham Awasthi"));
		//System.out.println(repo.findByMarks(99));

		// Update
		s2.setName("Vishal Chopra");
		repo.save(s2);

		// Delete
		repo.delete(s2);
	}

}

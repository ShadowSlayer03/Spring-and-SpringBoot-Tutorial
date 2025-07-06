package com.arjun.SpringJDBCProject;

import com.arjun.SpringJDBCProject.Model.Student;
import com.arjun.SpringJDBCProject.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcProjectApplication.class, args);

        Student s = context.getBean(Student.class);
        s.setRollNo(1);
        s.setMarks(50);
        s.setName("Revathi");

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println(students);
    }

}

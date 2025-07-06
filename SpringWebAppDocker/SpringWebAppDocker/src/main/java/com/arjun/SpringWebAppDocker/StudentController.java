package com.arjun.SpringWebAppDocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return repo.findAll();
    }

    @GetMapping("/addStudent")
    public void addStudent(){
        Student s = new Student();
        s.setAge(25);
        s.setName("Rohit");
        repo.save(s);
    }
}

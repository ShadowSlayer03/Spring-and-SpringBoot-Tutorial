package com.arjun.SpringJDBCProject.Repository;

import com.arjun.SpringJDBCProject.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";

        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows + " affected!");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";

        // RowMapper is used to get all the values from the ResultSet which previously we need to loop over.
        // When using RowMapper, we need custom implementation of getting ResultSet items.

        /*
        return jdbc.query(sql,(rs,rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
        */

        // BeanPropertyRowMapper is an implementation of RowMapper for Spring.
        // It is used when you need limited control, no mapping code and table row, object attributes are same.
        List<Student> students = jdbc.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return students;
    }
}

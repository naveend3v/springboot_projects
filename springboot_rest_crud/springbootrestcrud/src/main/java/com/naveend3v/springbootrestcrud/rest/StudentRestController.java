package com.naveend3v.springbootrestcrud.rest;

import com.naveend3v.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    private void loadData(){
        theStudents.add(new Student("Danish", "Duck"));
        theStudents.add(new Student("Mathan", "Kumar"));
        theStudents.add(new Student("Joseph", "Fernandez"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
}

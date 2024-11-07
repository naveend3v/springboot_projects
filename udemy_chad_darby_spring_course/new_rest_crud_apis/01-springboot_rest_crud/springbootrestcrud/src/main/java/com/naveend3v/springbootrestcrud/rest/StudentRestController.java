package com.naveend3v.springbootrestcrud.rest;

import com.naveend3v.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    private void loadData(){
        theStudents = new ArrayList<>();
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

        // Exception handling for when students not found.
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student ID not found : " + studentId);
        }
        return theStudents.get(studentId);
    }
}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentEntity;
import com.example.demo.services.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServices src;

    // ADD STUDENT
    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentEntity st) {
        return src.insertStudent(st);
    }

    // GET ALL STUDENTS
    @GetMapping("/all")
    public List<StudentEntity> getAllStudents() {
        return src.getAllStudents();
    }

    // GET ONE STUDENT BY ID
    @GetMapping("/{id}")
    public Optional<StudentEntity> getStudent(@PathVariable Long id) {
        return src.getOneStudent(id);
    }

    // DELETE STUDENT
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        src.deleteStudent(id);
        return "Student deleted successfully";
    }
}

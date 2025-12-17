
package com.example.demo.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.StudentEntity;
import com.example.demo.services.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentServices src;
    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentEntity st){
        return src.saveData(st);
    }
    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable int id){
        return src.getAll();
    }
    @PutMapping("/update/{id}")
    public StudentEntity updateStudent(@PathVariable int id,@RequestBody StudentEntity st){
        StudentEntity updated=src.updateStudent(id,st);
        if(updated!=null){
            return updated;
        }
        else{
            throw new RuntimeException("Student with ID "+id+" not found");
        }
    }
}
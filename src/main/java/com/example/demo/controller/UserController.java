StudentController.java

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity st) {
        return userService.insertUser(st);
    }
    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.getOneUser(id);
    }
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student st) {
        Optional<Student> studentOpt = studentService.getOneStudent(id);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            student.setCgpa(st.getCgpa());
            student.setDob(st.getDob());

            studentService.insertStudent(student);
            return "Updated Successfully";
        }
        return "Student Not Found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<User> user = studentService.getOneStudent(id);

        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully";
        }
        return "Student Not Found";
    }
}
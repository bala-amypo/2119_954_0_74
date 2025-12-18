package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;

import com.example.demo.service.UserService;


@RestController
@RequestMapping("/auth") 
public class User {

    private final User studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student st) {
        return studentService.insertStudent(st);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.getOneStudent(id);
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
            return "Updated Successfully ";
        }
        return "Student Not Found ";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getOneStudent(id);

        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully ";
        }
        return "Student Not Found ";
    }
}
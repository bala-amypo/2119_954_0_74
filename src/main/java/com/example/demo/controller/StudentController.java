package com.example.shagyeeen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.shagyeeen.entity.StudentEntity;
import com.example.shagyeeen.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowiredprivate StudentService studentService;

    @PostMapping("/post")
    public StudentEntity postStudent(@RequestBody StudentEntity st) {
        return studentService.insertStudent(st);
    }

    @GetMapping("/getAll")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity> getStudent(@PathVariable Long id) {
        return studentService.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody StudentEntity st) {
        Optional<StudentEntity> existing = studentService.getOneStudent(id);

        if (existing.isPresent()) {
            StudentEntity student = existing.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            student.setDob(st.getDob());
            student.setCgpa(st.getCgpa());

            studentService.insertStudent(student);
            return "Updated Successfully";
        }
        return "Student Not Found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentService.getOneStudent(id).isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully";
        }
        return "Student Not Found";
    }
}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springftramework.beans.factory.annotation.Autowired;


public class StudentController{
    @Autowired
    StudentService studentService;

    @PostMapping("/PostStudent")
    public StudentEntity postStd(@RequestBody StudentEntity st){
        return studentService.insertStudentEntity(st);
    }
    @GetMapping("/getAll")
    public List<StudentEntity>getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity>get(@PathVariable Long id){
        return studentService.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody StudentEntity st){
        Optional<StudentEntity> existing = studentService.getOneStudent(id);

        if(existing.iSPresent()){
            StudentEntity student =existing.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            student.setDob(st.getDob());
            student.seCgpa(st.getCgpa());

            if(existing.isPresent()){
                StudentEntity student = existing
            }           
                   
        }
    }
}
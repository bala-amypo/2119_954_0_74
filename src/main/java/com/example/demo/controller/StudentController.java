package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springftramework.beans.factory.annotation.Autowired;


public class StudentController{
    @Autowired
    StudentService ser;

    @PostMapping("/PostStudent")
    public StudentEntity postStd(@RequestBody StudentEntity st){
        return StudentService.insertStudentEntity(st);
    }
    @GetMapping("/getAll")
    public List<StudentEntity>getAll(){
        return StudentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity>get(@PathVariable Long id){
        return StudentService.getOneStudent(id);
    }
}
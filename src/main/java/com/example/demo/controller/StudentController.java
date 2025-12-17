package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springftramework.beans.factory.annotation.Autowired;


public class StudentController{
    @Autowired
    StudentService ser;

    @PostMapping("/PostStudent")
    public StudentEntity postStd(@RequestBody StudentController)
}
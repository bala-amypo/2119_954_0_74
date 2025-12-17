package com.example.demo.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;

@Service
public class StudentService{
    private final Map<Long, StudentEntity> store = new HashMap<>();
    private long counter = 1;

    public StudentEntity insertStudent(StudentEntity student){
        
    }
}
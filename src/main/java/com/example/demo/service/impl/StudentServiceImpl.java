package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Servicepublic class StudentServiceImpl implements StudentService {

    @Autowiredprivate StudentRepository studentRepository;

    @Overridepublic StudentEntity insertStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Overridepublicpublic List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Overridepublicpublic Optional<StudentEntity> getOneStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Overridepublicpublic void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

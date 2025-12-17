package com.example.shagyeeen.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.shagyeeen.entity.StudentEntity;

@Servicepublic class StudentService {

    private final Map<Long, StudentEntity> store = new HashMap<>();
    private long counter = 1;

    public StudentEntity insertStudent(StudentEntity student) {
        if (student.getId() == null) {
            student.setId(counter++);
        }
        store.put(student.getId(), student);
        return student;
    }

    public List<StudentEntity> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    public Optional<StudentEntity> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void deleteStudent(Long id) {
        store.remove(id);
    }
}

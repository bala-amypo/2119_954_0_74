package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.blind.annotation.*;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestControllerr
@RequestMapping("/student")
public class StudentController{
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/PostStudent")
    public StudentEntity postStudent(@RequestBody StudentEntity st){
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
                StudentEntity student = existing.get();
                student.setName(st.getName());
                student.setEmail(st.getEmail());
                student.setDob(st.getDob());
                student.setCgpa(st.getCgpa());

                studentService.insertStudent(student);
                return  "Updated Successfully";
            }
            return "Student Not Found";           
                   
        }

        @DeleteMapping("/delete/{id}")
        public String deleteStudent(@PathVariable Long id){
                Optional<StudentEntity> student = studentSevi
        }
    }
}
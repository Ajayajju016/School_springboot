package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class StudentController{

    @Autowired
    public StudentH2Service studentservice;
    
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return studentservice.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentservice.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentservice.addStudent(student);
    }
    @PostMapping("/students/bulk")
    public ArrayList<Student> addStudents(@RequestBody Student student){
        return studentservice.addStudent(ArrayList<Student>);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId , @RequestBody Student student){
        return studentservice.updateStudent(studentId,student);
    }

    @DeleteMapping("students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentservice.deleteStudent(studentId);
    }
}
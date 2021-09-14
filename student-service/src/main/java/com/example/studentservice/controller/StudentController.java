package com.example.studentservice.controller;

import com.example.studentservice.model.StudentEntity;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private Environment environment;
    private StudentService studentService;

    @Autowired
    public StudentController(Environment environment, StudentService studentService) {
        this.environment = environment;
        this.studentService = studentService;
    }

    @GetMapping("/status/check")
    public String checkStatus()
    {
        return "school-service is up and running on port: "+environment.getProperty("local.server.port");
    }
    @GetMapping("/{schoolName}")
    public Iterable<StudentEntity> findStudentBySchoolName(@PathVariable("schoolName") String schoolName)
    {
        return studentService.findBySchoolName(schoolName);
    }
}

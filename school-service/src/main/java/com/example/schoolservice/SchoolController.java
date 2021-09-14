package com.example.schoolservice;

import com.example.schoolservice.response.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private RestTemplate restTemplate;

    @Autowired
    public SchoolController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{schoolName}")
    public ResponseEntity<Iterable<StudentEntity>> getStudentBySchoolName(@PathVariable("schoolName") String schoolName)
    {
        Iterable<StudentEntity> studentEntities=restTemplate.getForObject("http://student-ws/students/"+schoolName,Iterable.class);
        return ResponseEntity.ok(studentEntities);
    }
}

package com.example.studentservice.service;

import com.example.studentservice.model.StudentEntity;

public interface StudentService {

    public Iterable<StudentEntity> findBySchoolName(String schoolName);
}

package com.example.studentservice.service;

import com.example.studentservice.dao.StudentDao;
import com.example.studentservice.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Iterable<StudentEntity> findBySchoolName(String schoolName) {
        return studentDao.findBySchoolName(schoolName);
    }
}

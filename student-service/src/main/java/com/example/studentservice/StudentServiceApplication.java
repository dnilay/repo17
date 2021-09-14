package com.example.studentservice;

import com.example.studentservice.dao.StudentDao;
import com.example.studentservice.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication implements CommandLineRunner {
private StudentDao studentDao;
        @Autowired
    public StudentServiceApplication(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-1","3","ABCD"));
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-2","3","ABCD"));
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-3","3","ABCD"));
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-4","3","XYZ"));
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-5","3","XYZ"));
        studentDao.save(new StudentEntity(new Random().nextInt(10000),"Student-6","3","XYZ"));
    }
}

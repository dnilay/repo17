package com.example.studentservice.dao;

import com.example.studentservice.model.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<StudentEntity,Integer> {
    @Query
    public Iterable<StudentEntity> findBySchoolName(String schoolName);
}

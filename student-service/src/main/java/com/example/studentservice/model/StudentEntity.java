package com.example.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentid;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_standard")
    private String standard;
    @Column(name = "school_name")
    private String schoolName;
}

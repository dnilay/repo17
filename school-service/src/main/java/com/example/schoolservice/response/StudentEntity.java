package com.example.schoolservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentEntity {

    private Integer studentid;

    private String studentName;

    private String standard;

    private String schoolName;
}

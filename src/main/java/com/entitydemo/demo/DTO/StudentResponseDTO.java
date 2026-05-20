package com.entitydemo.demo.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class StudentResponseDTO {
      UUID enrollmentNo;

    String studentName;

    int age;

    String programName;

    String address;
}

package com.entitydemo.demo.Service;

import java.util.UUID;

import com.entitydemo.demo.DTO.StudentRequestDTO;
import com.entitydemo.demo.DTO.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);

    StudentResponseDTO getStudent(UUID enrollmentNo);

    String deleteStudent(UUID enrollmentNo);

    StudentResponseDTO updateStudent(UUID enrollmentNo ,StudentRequestDTO studentRequestDTO );
}

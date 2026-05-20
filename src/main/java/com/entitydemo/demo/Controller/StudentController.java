package com.entitydemo.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entitydemo.demo.DTO.StudentRequestDTO;
import com.entitydemo.demo.DTO.StudentResponseDTO;
import com.entitydemo.demo.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.createStudent(studentRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<StudentResponseDTO> getStudent(@RequestParam UUID enrollmentNo) {
        return new ResponseEntity<>(studentService.getStudent(enrollmentNo), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam UUID enrollmentNo) {
        return new ResponseEntity<String>(studentService.deleteStudent(enrollmentNo), HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<StudentResponseDTO> updateStudent(@RequestParam UUID enrollmentNo,
            @RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<StudentResponseDTO>(studentService.updateStudent(enrollmentNo, studentRequestDTO),
                HttpStatus.OK);
    }

}

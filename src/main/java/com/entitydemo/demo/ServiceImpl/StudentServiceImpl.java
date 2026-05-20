package com.entitydemo.demo.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entitydemo.demo.DTO.StudentRequestDTO;
import com.entitydemo.demo.DTO.StudentResponseDTO;
import com.entitydemo.demo.Entity.Student;
import com.entitydemo.demo.Repository.StudentRepository;
import com.entitydemo.demo.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        Student student1 = new Student();
        student1.setAddress(studentRequestDTO.getAddress());
        student1.setAge(studentRequestDTO.getAge());
        student1.setProgramName(studentRequestDTO.getProgramName());
        student1.setStudentName(studentRequestDTO.getStudentName());
        Student newStudent = studentRepository.save(student1);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(null, null, 0, null, null);
        studentResponseDTO.setAddress(newStudent.getAddress());
        studentResponseDTO.setAge(newStudent.getAge());
        studentResponseDTO.setEnrollmentNo(newStudent.getEnrollmentNo());
        studentResponseDTO.setProgramName(newStudent.getProgramName());
        studentResponseDTO.setStudentName(newStudent.getStudentName());
        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudent(UUID enrollmentNo) {
        Student newStudent = studentRepository.getReferenceById(enrollmentNo);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(null, null, 0, null, null);
        studentResponseDTO.setAddress(newStudent.getAddress());
        studentResponseDTO.setAge(newStudent.getAge());
        studentResponseDTO.setEnrollmentNo(newStudent.getEnrollmentNo());
        studentResponseDTO.setProgramName(newStudent.getProgramName());
        studentResponseDTO.setStudentName(newStudent.getStudentName());
        return studentResponseDTO;
    }

    @Override
    public String deleteStudent(UUID enrollmentNo) {
        studentRepository.deleteById(enrollmentNo);
        return "Student deleted";
    }

    @Override
    public StudentResponseDTO updateStudent(UUID enrollmentNo, StudentRequestDTO studentRequestDTO) {
        Student oldStudent = studentRepository.getReferenceById(enrollmentNo);
        if (studentRequestDTO.getAddress() != null) {
            oldStudent.setAddress(studentRequestDTO.getAddress());
        }
        if (studentRequestDTO.getAge() != null) {
            oldStudent.setAge(studentRequestDTO.getAge());
        }
        if (studentRequestDTO.getProgramName() != null) {
            oldStudent.setProgramName(studentRequestDTO.getProgramName());
        }
        if (studentRequestDTO.getStudentName() != null) {
            oldStudent.setStudentName(studentRequestDTO.getStudentName());
        }
        Student newStudent = studentRepository.save(oldStudent);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(null, null, 0, null, null);
        studentResponseDTO.setAddress(newStudent.getAddress());
        studentResponseDTO.setAge(newStudent.getAge());
        studentResponseDTO.setEnrollmentNo(newStudent.getEnrollmentNo());
        studentResponseDTO.setProgramName(newStudent.getProgramName());
        studentResponseDTO.setStudentName(newStudent.getStudentName());
        return studentResponseDTO;
    }

}

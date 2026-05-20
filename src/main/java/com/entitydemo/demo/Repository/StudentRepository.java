package com.entitydemo.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entitydemo.demo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    
}

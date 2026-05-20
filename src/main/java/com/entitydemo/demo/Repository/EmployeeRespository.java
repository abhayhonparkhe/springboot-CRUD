package com.entitydemo.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entitydemo.demo.Entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee,UUID> {
    
}

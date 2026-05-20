package com.entitydemo.demo.Service;

import java.util.UUID;

import com.entitydemo.demo.DTO.EmployeeRequestDTO;
import com.entitydemo.demo.DTO.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getEmployee(UUID empUuid);

    String deleteEmployee(UUID empUuid);

    EmployeeResponseDTO updateEmployee(UUID empUuid, EmployeeRequestDTO employeeRequestDTO);

}
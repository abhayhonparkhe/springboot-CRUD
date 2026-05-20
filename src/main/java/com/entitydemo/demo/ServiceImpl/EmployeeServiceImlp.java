package com.entitydemo.demo.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entitydemo.demo.DTO.EmployeeRequestDTO;
import com.entitydemo.demo.DTO.EmployeeResponseDTO;
import com.entitydemo.demo.Entity.Employee;
import com.entitydemo.demo.Repository.EmployeeRespository;
import com.entitydemo.demo.Service.EmployeeService;

@Service
public class EmployeeServiceImlp implements EmployeeService {

    private EmployeeRespository employeeRespository;

    @Autowired
    public EmployeeServiceImlp(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;

    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee1 = new Employee();
        employee1.setDepartment(employeeRequestDTO.getDepartment());
        employee1.setEmployeeName(employeeRequestDTO.getEmployeeName());
        employee1.setSalary(employeeRequestDTO.getSalary());
        Employee newEmployee = employeeRespository.save(employee1);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(null, null, 0, null);
        employeeResponseDTO.setDepartment(newEmployee.getDepartment());
        employeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        employeeResponseDTO.setSalary(newEmployee.getSalary());
        employeeResponseDTO.setEmpUuid(newEmployee.getEmpUuid());
        return employeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO getEmployee(UUID empUuid) {
        Employee newEmployee = employeeRespository.getReferenceById(empUuid);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(null, null, 0, null);
        employeeResponseDTO.setDepartment(newEmployee.getDepartment());
        employeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        employeeResponseDTO.setSalary(newEmployee.getSalary());
        employeeResponseDTO.setEmpUuid(newEmployee.getEmpUuid());
        return employeeResponseDTO;
    }

    @Override
    public String deleteEmployee(UUID empUuid) {
        employeeRespository.deleteById(empUuid);
        return "Employee deleted";
    }

    @Override
    public EmployeeResponseDTO updateEmployee(UUID empUuid, EmployeeRequestDTO employeeRequestDTO) {
        Employee oldEmployee = employeeRespository.getReferenceById(empUuid);
        if (employeeRequestDTO.getDepartment() != null) {
            oldEmployee.setDepartment(employeeRequestDTO.getDepartment());
        }
        if (employeeRequestDTO.getEmployeeName() != null) {
            oldEmployee.setEmployeeName(employeeRequestDTO.getEmployeeName());
        }
        if (employeeRequestDTO.getSalary() != null) {
            oldEmployee.setSalary(employeeRequestDTO.getSalary());
        }
        Employee newEmployee = employeeRespository.save(oldEmployee);

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(null, null, 0, null);
        employeeResponseDTO.setDepartment(newEmployee.getDepartment());
        employeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        employeeResponseDTO.setSalary(newEmployee.getSalary());
        employeeResponseDTO.setEmpUuid(newEmployee.getEmpUuid());
        return employeeResponseDTO;
    }

}

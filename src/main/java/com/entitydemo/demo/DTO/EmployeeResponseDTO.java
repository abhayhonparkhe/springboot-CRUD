package com.entitydemo.demo.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {
    UUID empUuid;
    String employeeName;
    int salary;
    String department;

}

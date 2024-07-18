package com.employee.incometax.DTO;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
    private int employeeCode;
    private String firstName;
    private String lastName;
    private double tax;
    private double cess;
}

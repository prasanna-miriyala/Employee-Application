package com.employee.incometax.repository;

import com.employee.incometax.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmployeeCode(int employeeCode);
}


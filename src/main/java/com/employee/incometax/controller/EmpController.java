package com.employee.incometax.controller;

import com.employee.incometax.DTO.EmpDTO;
import com.employee.incometax.entity.Employee;
import com.employee.incometax.repository.EmpRepository;
//import com.employee.incometax.service.EmpService;
import com.employee.incometax.service.EmployeeServ2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmployeeServ2 empService;

//    @PostMapping("/save")
//    public ResponseEntity<Employee> save(@RequestBody EmpDTO empDTO){
//        return new ResponseEntity<>(empService.saveEmp(empDTO), HttpStatus.CREATED);
//    }
    @GetMapping("/getAll" )
    public ResponseEntity<List<Employee>> getAll( ) {
        return ResponseEntity.ok (empService.getEmployee());
    }
    @GetMapping("/get/{employeeCode}")
    public ResponseEntity<EmpDTO> get(@PathVariable int employeeCode){
        return ResponseEntity.ok ( empService.getOne(employeeCode));
    }
}










package com.employee.incometax.service;

import com.employee.incometax.DTO.EmpDTO;
import com.employee.incometax.entity.Employee;
import com.employee.incometax.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class EmployeeServ2   {

    @Autowired

    private EmpRepository empRepository;


    public List<Employee> getEmployee(){
       return empRepository.findAll ();
    }
    public  EmpDTO getOne(int employeeCode){
        Employee emp = empRepository.findByEmployeeCode (employeeCode );
         double tax = 0;
        EmpDTO empDTO = new EmpDTO (  );
         long monsal = (long) emp.getSalary ();
         long sal = monsal * 12;
// in the interest of time I am not considering doj for tax calculation
        if (sal <= 250000) {
            System.out.println("no tax");
        } else if (sal > 250000 && sal <= 500000) {
            tax = sal * 0.05;
            System.out.println("tax amount is" + tax);
        } else if (sal > 500000 && sal <= 1000000) {
            tax = sal * 0.10;
            System.out.println("tax amount is" + tax);
            System.out.println("tax cess amount is" );
        }else if (sal > 1000000 ) {
            tax = sal * 0.20;
            System.out.println("tax amount is" + tax);
            if(sal > 2500000){
              long  totalsal = sal;
              long cesssal = totalsal - 2500000;

              double cess = cesssal * 0.02;
                System.out.println("tax cess amount is"+cess );
                empDTO.setCess ( cess );
            }

        } else
            System.out.println("entered amount is not employee salary");

        System.out.println (tax );
        empDTO.setEmployeeCode ( emp.getEmployeeCode () );
        empDTO.setFirstName ( emp.getFirstName () );
        empDTO.setLastName ( emp.getLastName () );
        empDTO.setTax (   tax );
        return empDTO;
    }
}

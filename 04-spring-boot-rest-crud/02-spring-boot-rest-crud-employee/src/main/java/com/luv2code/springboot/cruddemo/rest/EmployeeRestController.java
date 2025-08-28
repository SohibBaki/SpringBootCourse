package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class EmployeeRestController {

private EmployeeService employeeService;

    //quick and dirty : inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET  /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("User Id not found - " + employeeId);
        }
        return theEmployee;
    }

    //add mapping for PST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}

package com.naveend3v.cruddemo.rest;

import com.naveend3v.cruddemo.dao.EmployeeDAO;
import com.naveend3v.cruddemo.dao.EmployeeDAOImpl;
import com.naveend3v.cruddemo.entity.Employee;
import com.naveend3v.cruddemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable int id){
        Employee employee =  employeeService.getEmployee(id);
        if(employee == null){
            throw new RuntimeException("Employee not found with employee id: " + id);
        } else {
            return employee;
        }
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee newEmployee = employeeService.addEmployee(theEmployee);
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.addEmployee(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String removeEmployee(@PathVariable int employeeID){
        Employee tempEmployee = employeeService.getEmployee(employeeID);
        if(tempEmployee == null){
            throw new RuntimeException("Employee not found with id - " + employeeID);
        } else {
            employeeService.removeEmployee(employeeID);
            return "Deleted Employee with id - " + employeeID;
        }
    }


}

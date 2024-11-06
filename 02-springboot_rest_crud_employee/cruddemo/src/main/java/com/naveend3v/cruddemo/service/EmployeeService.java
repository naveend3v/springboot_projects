package com.naveend3v.cruddemo.service;

import com.naveend3v.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int employeeId);
    Employee addEmployee(Employee newEmployee);
    void removeEmployee(int employeeId);
}

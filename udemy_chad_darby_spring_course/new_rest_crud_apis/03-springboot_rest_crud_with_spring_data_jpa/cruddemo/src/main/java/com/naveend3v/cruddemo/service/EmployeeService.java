package com.naveend3v.cruddemo.service;

import com.naveend3v.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee newEmployee);
    void delete(int employeeId);
}

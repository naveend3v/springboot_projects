package com.naveend3v.cruddemo.dao;

import com.naveend3v.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployee(int employeeId);
    Employee addEmployee(Employee newEmployee);
    void removeEmployee(int employeeId);
}

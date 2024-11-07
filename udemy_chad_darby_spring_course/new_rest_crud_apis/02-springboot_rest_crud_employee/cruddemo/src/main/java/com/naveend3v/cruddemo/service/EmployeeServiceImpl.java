package com.naveend3v.cruddemo.service;

import com.naveend3v.cruddemo.dao.EmployeeDAO;
import com.naveend3v.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    // define Employee DAO
    private EmployeeDAO employeeDAO;

    // Constructor injection to inject employee DAO
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEployeeDAO){
        employeeDAO = theEployeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee newEmployee) {
        return employeeDAO.addEmployee(newEmployee);
    }

    @Override
    @Transactional
    public void removeEmployee(int employeeId) {
        employeeDAO.removeEmployee(employeeId);
    }

}

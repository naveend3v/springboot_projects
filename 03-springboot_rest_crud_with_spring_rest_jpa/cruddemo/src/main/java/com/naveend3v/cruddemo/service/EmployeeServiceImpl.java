package com.naveend3v.cruddemo.service;

import com.naveend3v.cruddemo.dao.EmployeeRepository;
import com.naveend3v.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    // define Employee Repository
    private EmployeeRepository employeeRepository;

    // Constructor injection to inject employee DAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee find(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee save(Employee newEmployee) {
        return employeeRepository.findBy(newEmployee);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}

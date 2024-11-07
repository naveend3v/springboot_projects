package com.naveend3v.cruddemo.service;

import com.naveend3v.cruddemo.dao.EmployeeRepository;
import com.naveend3v.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Employee findById(int employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
            return theEmployee;
        } else {
            throw new RuntimeException("Did not find employee with id - " + employeeId);
        }
    }

    @Override
    public Employee save(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}

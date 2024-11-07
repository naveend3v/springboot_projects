package com.naveend3v.cruddemo.dao;

import com.naveend3v.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;
    private List<Employee> employees;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Get all employees
    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> theEmployees = entityManager.createQuery("FROM Employee",Employee.class);
        employees = theEmployees.getResultList();
        return employees;
    }

    // Get employee by employee id
    @Override
    public Employee getEmployee(int employeeId) {
        return entityManager.find(Employee.class,employeeId);
    }

    @Override
    public Employee addEmployee(Employee newEmployee){
        return entityManager.merge(newEmployee);
    }

    @Override
    public void removeEmployee(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }


}

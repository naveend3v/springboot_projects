package com.naveend3v.cruddemo.dao;

import com.naveend3v.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    // No need any code - JpaRepository handle everything
}

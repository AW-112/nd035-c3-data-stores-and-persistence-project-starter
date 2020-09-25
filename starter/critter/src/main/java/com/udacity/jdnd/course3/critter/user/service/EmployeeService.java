package com.udacity.jdnd.course3.critter.user.service;

import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) { return employeeRepository.save(employee); }
    public Employee getEmployeeById(long id) { return employeeRepository.findById(id).orElseGet(null); }
}

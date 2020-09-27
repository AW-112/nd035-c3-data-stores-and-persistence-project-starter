package com.udacity.jdnd.course3.critter.user.service;

import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseGet(null);
    }

    public List<Employee> getEmployeesByIds(List<Long> employeeIds) {
        return employeeRepository.findByIds(employeeIds);
    }

    public List<Employee> getEmployeesByService(LocalDate date, Set<EmployeeSkill> skills) {
        return employeeRepository.findEmployeesForService(date.getDayOfWeek())
                .stream().filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
    }
}

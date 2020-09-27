package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.user.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    public Employee DTOToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSkills(employeeDTO.getSkills());
        employee.setDaysAvailable(employeeDTO.getDaysAvailable());

        return employee;
    }

    public EmployeeDTO entityToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSkills(employee.getSkills());
        employeeDTO.setDaysAvailable(employee.getDaysAvailable());

        return employeeDTO;
    }

    public List<EmployeeDTO> entitiesToDTOs(List<Employee> employees) {
        return employees.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}

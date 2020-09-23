package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.user.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    public Employee DTOToEntity(EmployeeDTO EmployeeDTO) {
        Employee Employee = new Employee();
        Employee.setName(EmployeeDTO.getName());
        Employee.setSkills(EmployeeDTO.getSkills());
        Employee.setDaysAvailable(EmployeeDTO.getDaysAvailable());

        return Employee;
    }

    public EmployeeDTO entityToDTO(Employee Employee) {
        EmployeeDTO EmployeeDTO = new EmployeeDTO();
        EmployeeDTO.setId(Employee.getId());
        EmployeeDTO.setName(Employee.getName());
        EmployeeDTO.setSkills(Employee.getSkills());
        EmployeeDTO.setDaysAvailable(Employee.getDaysAvailable());

        return EmployeeDTO;
    }

    public List<EmployeeDTO> entitiesToDTOs(List<Employee> Employees) {
        return Employees.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}

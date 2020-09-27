package com.udacity.jdnd.course3.critter.schedule.mapper;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    PetService petService;

    public Schedule DTOtoEntity(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setEmployees(employeeService.getEmployeesByIds(scheduleDTO.getEmployeeIds()));
        schedule.setPets(petService.getPetsByIds(scheduleDTO.getPetIds()));
        schedule.setActivities(scheduleDTO.getActivities());
        return schedule;
    }

    public ScheduleDTO entityToDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setActivities(schedule.getActivities());
        scheduleDTO.setEmployeeIds(schedule.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        scheduleDTO.setPetIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return scheduleDTO;
    }

    public List<ScheduleDTO> entitiesToDTOs(List<Schedule> schedules) {
        return schedules.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}

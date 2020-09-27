package com.udacity.jdnd.course3.critter.schedule.controller;

import com.udacity.jdnd.course3.critter.schedule.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.mapper.ScheduleMapper;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleMapper.entityToDTO(scheduleService.saveSchedule(scheduleMapper.DTOtoEntity(scheduleDTO)));
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleMapper.entitiesToDTOs(scheduleService.getSchedules());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return scheduleMapper.entitiesToDTOs(scheduleService.getSchedulesByPet(petId));
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleMapper.entitiesToDTOs(scheduleService.getSchedulesByEmployee(employeeId));
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return scheduleMapper.entitiesToDTOs(scheduleService.getSchedulesByCustomer(customerId));
    }
}

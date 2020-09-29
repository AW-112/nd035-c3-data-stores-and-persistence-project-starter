package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;
import com.udacity.jdnd.course3.critter.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PetService petService;

    @Autowired
    CustomerService customerService;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByEmployee(long employeeId) {
        return scheduleRepository.findByEmployee(employeeService.getEmployeeById(employeeId));
    }

    public List<Schedule> getSchedulesByPet(long petId) {
        return scheduleRepository.findByPet(petService.getPetById(petId));
    }

    public List<Schedule> getSchedulesByCustomer(long customerId) {
        return scheduleRepository.findByOwner(customerService.getCustomerById(customerId));
    }
}

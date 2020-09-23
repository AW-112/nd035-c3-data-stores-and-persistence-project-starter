package com.udacity.jdnd.course3.critter.schedule.entity;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.entity.EmployeeSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany()
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;

    @ManyToMany()
    @JoinColumn(name = "pet_id")
    private List<Pet> pets;

    @ElementCollection(targetClass = EmployeeSkill.class)
    @CollectionTable(name = "activities")
    private Set<EmployeeSkill> activities;

    private LocalDate date;
}

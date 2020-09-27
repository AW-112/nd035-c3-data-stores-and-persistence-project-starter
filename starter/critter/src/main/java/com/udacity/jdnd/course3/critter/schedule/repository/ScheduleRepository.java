package com.udacity.jdnd.course3.critter.schedule.repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.acl.Owner;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from Schedule s where :employee member of employees")
    List<Schedule> findByEmployee(Employee employee);

    @Query("select s from Schedule s where :pet member of pets")
    List<Schedule> findByPet(Pet pet);

    @Query("select s from Schedule s inner join s.pets p where p.customer = :customer")
    List<Schedule> findByOwner(Customer customer);
}

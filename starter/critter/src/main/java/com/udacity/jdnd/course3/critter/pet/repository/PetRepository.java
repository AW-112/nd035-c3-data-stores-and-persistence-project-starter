package com.udacity.jdnd.course3.critter.pet.repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("select p from Pet p where p.customer = :customer")
    List<Pet> findAllByCustomer(Customer customer);

    @Query("select p from Pet p where id in :petIds")
    List<Pet> findByIds(List<Long> petIds);
}
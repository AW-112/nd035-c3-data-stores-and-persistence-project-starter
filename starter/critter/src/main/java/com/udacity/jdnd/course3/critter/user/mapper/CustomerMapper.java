package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public Customer DTOToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setNotes(customerDTO.getNotes());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customer;
    }

    public CustomerDTO entityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setNotes(customer.getNotes());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setPetIds(getPetIds(customer.getPets()));

        return customerDTO;
    }

    public List<CustomerDTO> entitiesToDTOs(List<Customer> customers) {
        return customers.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    private List<Long> getPetIds(List<Pet> pets) {
        List<Long> petIds = new ArrayList<Long>();
        if(pets != null) {
            petIds = pets.stream().map(Pet::getId).collect(Collectors.toList());
        }
        return petIds;
    }
}

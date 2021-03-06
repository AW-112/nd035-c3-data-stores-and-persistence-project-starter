package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Pet savePet(Pet pet) {
        Pet newPet = petRepository.save(pet);
        Customer customer = customerRepository.findById(pet.getCustomer().getId()).get();
        customer.addPet(newPet);
        customerRepository.save(customer);
        return newPet;
    }

    public Pet getPetById(long petId) { return petRepository.findById(petId).get(); }

    public List<Pet> getPetsByIds(List<Long> petIds) { return petRepository.findByIds(petIds); }

    public List<Pet> getPetsByOwner(Customer customer) { return petRepository.findAllByCustomer(customer); }

    public List<Pet> getPets() { return petRepository.findAll(); }
}

package com.udacity.jdnd.course3.critter.pet.controller;

import com.udacity.jdnd.course3.critter.pet.dto.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetMapper petMapper;

    @Autowired
    PetService petService;

    @Autowired
    CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Customer customer = null;
        if(petDTO.getOwnerId() > 0) {
            customer = customerService.getCustomerById(petDTO.getOwnerId());
        }
        Pet pet = petMapper.DTOToEntity(petDTO);
        pet.setCustomer(customer);
        return petMapper.entityToDTO(petService.savePet(pet));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petMapper.entityToDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        return petMapper.entitiesToDTOs(petService.getPets());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        Customer customer = customerService.getCustomerById(ownerId);
        return petMapper.entitiesToDTOs(petService.getPetsByOwner(customer));
    }
}

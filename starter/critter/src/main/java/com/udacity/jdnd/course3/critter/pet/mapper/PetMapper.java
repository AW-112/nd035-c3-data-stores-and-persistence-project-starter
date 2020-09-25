package com.udacity.jdnd.course3.critter.pet.mapper;

import com.udacity.jdnd.course3.critter.pet.dto.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {
    public Pet DTOToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setName(petDTO.getName());
        pet.setNotes(petDTO.getNotes());
        pet.setType(petDTO.getType());
        return pet;
    }

    public PetDTO entityToDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setName(pet.getName());
        petDTO.setNotes(pet.getNotes());
        petDTO.setType(pet.getType());

        if (pet.getCustomer() != null) {
            petDTO.setOwnerId(pet.getCustomer().getId());
        }

        return petDTO;
    }

    public List<PetDTO> entitiesToDTOs(List<Pet> pets) {
        return pets.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}

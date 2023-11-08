package com.anderson.pawshake.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.pet.domain.Pet;
import com.anderson.pawshake.pet.domain.PetDto;
import com.anderson.pawshake.pet.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	/*
	 * Create pet
	 */
	public Pet createPet(PetDto pet) {				
		Pet newPet = Pet.createPet(pet);		
		
		return petRepository.save(newPet);
	}

	/*
	 * Modify pet information
	 */
	public Pet updatePet(PetDto pet) {
		Pet originPet = petRepository.findById(pet.getId()).orElseThrow();
		
		originPet.setName(pet.getName());
		originPet.setUserId(pet.getUserId());
		originPet.setBirthYear(pet.getBirthYear());
		originPet.setBreed(pet.getBreed());
		originPet.setSize(pet.getSize());
		originPet.setGender(pet.getGender());
		originPet.setCharacteristic(pet.getCharacteristic());
		
		return petRepository.save(originPet);
	}

	/*
	 * Search pet
	 */		
	public Pet findById(Long id) {
		return petRepository.findById(id).orElseThrow();
	}
	
	/*
	 *  Get all pet
	 */	
	public List<Pet> getAllPet() {
		return petRepository.findAll();
	}
	
	/*
	 *  Get pet by userId
	 */
	public List<Pet> getPetByUserId(Long userId) {
		return petRepository.findAllPetByUserId(userId);
	}
}

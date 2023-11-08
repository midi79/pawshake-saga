package com.anderson.pawshake.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.pet.domain.Pet;
import com.anderson.pawshake.pet.domain.PetDto;
import com.anderson.pawshake.pet.service.PetService;


@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

	@Autowired
	private PetService petService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createPet(@RequestBody final PetDto pet) {

		Pet newPet = petService.createPet(pet);
		
		return ResponseEntity.ok(newPet.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Pet> getPet(@PathVariable final Long id) {

		Pet pet = petService.findById(id);
		
		return ResponseEntity.ok(pet);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<Pet>> getAllPet() {

		return ResponseEntity.ok(petService.getAllPet());
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Pet>> getAllPetByUser(@PathVariable final Long userId) {

		return ResponseEntity.ok(petService.getPetByUserId(userId));
	}
	
}

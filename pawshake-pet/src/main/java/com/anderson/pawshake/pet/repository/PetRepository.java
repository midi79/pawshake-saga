package com.anderson.pawshake.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.pet.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	List<Pet> findAllPetByUserId(Long userId);
}


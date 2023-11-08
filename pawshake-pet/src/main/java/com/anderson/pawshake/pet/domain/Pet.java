package com.anderson.pawshake.pet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pet")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet extends BaseTimeEntity implements Serializable {
		
	private static final long serialVersionUID = 3290892709884826511L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Column(name = "birth_year")
	private String birthYear;
	
	@NotNull
	@Column(name = "breed")
	private String breed;
	
	@NotNull
	@Column(name = "size")
	private String size;
	
	@NotNull
	@Column(name = "gender")
	private String gender;
	
	@NotNull
	@Column(name = "characteristic")
	private String characteristic;
	
	
	public Pet() {		
	}	
	
	public Pet(PetDto pet) {
		this.name = pet.getName();
		this.userId = pet.getUserId();
		this.birthYear = pet.getBirthYear();
		this.breed = pet.getBreed();
		this.size = pet.getSize();
		this.gender = pet.getGender();
		this.characteristic = pet.getCharacteristic();				
	}
	
	public static Pet createPet(PetDto pet) {
		return new Pet(pet);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
		
}

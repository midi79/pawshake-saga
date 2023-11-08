package com.anderson.pawshake.sitter.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_sitter")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sitter extends BaseTimeEntity implements Serializable {
		
	private static final long serialVersionUID = 511410806867527577L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;
		
	@NotNull
	@Column(name = "address")
	private String address;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "phone")
	private String phone;
		
	@NotNull
	@Column(name = "service_type")
	private String serviceType;
	
	@NotNull
	@Column(name = "price")
	private Long price;
	
	@Column(name = "available_time")
	private String availableTime;
	
	@NotNull
	@Column(name = "introduce")
	private String introduce;
	
	@Column(name = "experience")
	private Long experience;
	
	@NotNull
	@Column(name = "language")
	private String language;
		
	public Sitter() {		
	}	
	
	public Sitter(SitterDto sitter) {
		this.name = sitter.getName();
		this.status = sitter.getStatus();
		this.address = sitter.getAddress();
		this.email = sitter.getEmail();
		this.phone = sitter.getPhone();	
		this.serviceType = sitter.getServiceType();
		this.price = sitter.getPrice();
		this.availableTime = sitter.getAvailableTime();
		this.introduce = sitter.getIntroduce();
		this.experience = sitter.getExperience();
		this.language = sitter.getLanguage();
	}
	
	public static Sitter createSitter(SitterDto sitter) {
		return new Sitter(sitter);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Long getExperience() {
		return experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}

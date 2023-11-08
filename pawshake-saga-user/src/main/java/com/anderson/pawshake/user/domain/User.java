package com.anderson.pawshake.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;


@Entity
@Table(name="tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseTimeEntity implements Serializable {
		
	private static final long serialVersionUID = 3290892709884826511L;

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

//	@ElementCollection
//	@CollectionTable(name="tb_pet", joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
//	@JsonIgnore
//	private final List<Pet> pets = new ArrayList<>();
	
	public User() {		
	}	
	
	public User(UserDto user) {
		this.name = user.getName();
		this.status = user.getStatus();
		this.address = user.getAddress();
		this.email = user.getEmail();
		this.phone = user.getPhone();		
	}
	
	public static User createUser(UserDto user) {
		return new User(user);
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
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}

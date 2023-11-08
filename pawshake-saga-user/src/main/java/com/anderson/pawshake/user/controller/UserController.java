package com.anderson.pawshake.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.user.domain.User;
import com.anderson.pawshake.user.domain.UserDto;
import com.anderson.pawshake.user.service.UserChoreographySagaService;
import com.anderson.pawshake.user.service.UserSagaService;
import com.anderson.pawshake.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSagaService userSagaService;
	
	@Autowired
	private UserChoreographySagaService userChoreographySagaService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Long> createUser(@RequestBody final UserDto user) {

		User createUser = userService.createUser(user);
		
		return ResponseEntity.ok(createUser.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUser(@PathVariable final Long id) {

		User user = userService.findById(id);
		
		return ResponseEntity.ok(user);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser() {

		return ResponseEntity.ok(userService.getAllUser());
	}
	

	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<User> updateUserStatus(@PathVariable final Long id, @PathVariable final String status) {

		User updateUser = userService.updateStatus(id, status) ;
		
		return ResponseEntity.ok(updateUser);
	}	
	
	
	@PostMapping("/create/reservation") 
	public ResponseEntity<Long> createReservation() {
		return ResponseEntity.ok(userService.createReservation(userService.createReservationData()));
	}
	
		
	@PostMapping("/pay") 
	public ResponseEntity<HttpStatus> payReservation() {
		
		userSagaService.paySagaProcess();
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping("/choreography/pay")
	public ResponseEntity<HttpStatus> payReservationChoreography() {
		
		userChoreographySagaService.UpdateStatusPending();
		userChoreographySagaService.requestPay();
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	

}

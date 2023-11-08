package com.anderson.pawshake.user.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.user.domain.User;
import com.anderson.pawshake.user.domain.UserDto;
import com.anderson.pawshake.user.repository.UserRepository;
import com.anderson.pawshake.user.saga.ReservationSagaData;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CreateReservationService createReservationService;
	

	/*
	 * Create User
	 */
	public User createUser(UserDto user) {		
		
		User createUser = User.createUser(user);		
		
		return userRepository.save(createUser);
	}

	/*
	 * Modify User information
	 */
	public User updateUser(UserDto user) {
		User originUser = userRepository.findById(user.getId()).orElseThrow();
		
		originUser.setName(user.getName());		
		originUser.setAddress(user.getAddress());
		originUser.setEmail(user.getEmail());
		originUser.setPhone(user.getPhone());
		
		return userRepository.save(originUser);
	}
	
	/*
	 *  Update the status
	 */
	public User updateStatus(Long userId, String status) {
		User originUser = userRepository.findById(userId).orElseThrow();
		
		originUser.setStatus(status);
		
		return userRepository.save(originUser);
	}

	/*
	 * Search User
	 */		
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	/*
	 *  Get all user
	 */	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	/*
	 *  Create reservation by Feign client
	 */
	public Long createReservation(ReservationSagaData reservation) {
		return createReservationService.createReservation(reservation);
	}
	
	/*
	 * Generate Reservation data
	 */	
	public ReservationSagaData createReservationData() {
	
		LocalDate date = LocalDate.now();
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int duration = (int)(Math.random()*10);
		
		String status = "EMPTY";
		String serviceType = "Borading";		
		String fromDate = date.format(fm);
		String toDate = date.plusDays(duration).format(fm);		
		Long userId = 1L;		
		String userName = "Cheolkyu Lee";		
		Long petId = 1L;		
		String petName = "Black";			
		Long sitterId = 1L;		
		String sitterName = "Anderson";
		Long price = duration * 50L;
		
		return new ReservationSagaData(status, serviceType, fromDate, toDate, 
				userId, userName, petId, petName, sitterId, sitterName, price);
	}
		
}

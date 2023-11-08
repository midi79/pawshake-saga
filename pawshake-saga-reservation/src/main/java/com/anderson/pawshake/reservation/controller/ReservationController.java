package com.anderson.pawshake.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.reservation.domain.Reservation;
import com.anderson.pawshake.reservation.domain.ReservationDto;
import com.anderson.pawshake.reservation.service.ReservationService;


@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createReservation(@RequestBody final ReservationDto reservation) {

		Reservation newReservation = reservationService.createReservation(reservation);
		
		return ResponseEntity.ok(newReservation.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable final Long id) {

		Reservation reservation = reservationService.findById(id);
		
		return ResponseEntity.ok(reservation);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Reservation>> getAllReservation() {

		return ResponseEntity.ok(reservationService.getAllReservation());
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Reservation>> getAllReservationByUser(@PathVariable final Long userId) {

		return ResponseEntity.ok(reservationService.getReservationByUserId(userId));
	}

	@GetMapping("/sitter/{sitterId}")
	public ResponseEntity<List<Reservation>> getAllReservationBySitter(@PathVariable final Long sitterId) {

		return ResponseEntity.ok(reservationService.getReservationBySitterId(sitterId));
	}
	
	
	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<Reservation> updateReservationStatus(@PathVariable final Long id, @PathVariable final String status) {

		Reservation updateReservation = reservationService.updateStatus(id, status) ;
		
		return ResponseEntity.ok(updateReservation);
	}	

	
}

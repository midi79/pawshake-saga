package com.anderson.pawshake.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.reservation.domain.Reservation;
import com.anderson.pawshake.reservation.domain.ReservationDto;
import com.anderson.pawshake.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	/*
	 * Create reservation
	 */
	public Reservation createReservation(ReservationDto reservation) {				
		Reservation newReservation = Reservation.createReservation(reservation);		
		
		return reservationRepository.save(newReservation);
	}

	/*
	 * Modify reservation information
	 */
	public Reservation updateReservation(ReservationDto reservation) {
		Reservation originReservation = reservationRepository.findById(reservation.getId()).orElseThrow();
		
		originReservation.setServiceType(reservation.getServiceType());
		originReservation.setFromDate(reservation.getFromDate());
		originReservation.setToDate(reservation.getToDate());
		originReservation.setUserId(reservation.getUserId());
		originReservation.setUserName(reservation.getUserName());
		originReservation.setPetId(reservation.getPetId());
		originReservation.setPetName(reservation.getPetName());
		originReservation.setSitterId(reservation.getSitterId());
		originReservation.setSitterName(reservation.getSitterName());
		
		return reservationRepository.save(originReservation);
	}
	
	
	/*
	 * Update reservation status 
	 */
	public Reservation updateStatus(Long id, String status) {
		Reservation originReservation = reservationRepository.findById(id).orElseThrow();
		
		originReservation.setStatus(status);		
		
		return reservationRepository.save(originReservation);
	}
	
	
	/*
	 * Search reservation
	 */		
	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElseThrow();
	}
	
	/*
	 *  Get all reservation
	 */	
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}
	
	/*
	 *  Get reservation by userId
	 */
	public List<Reservation> getReservationByUserId(Long userId) {
		return reservationRepository.findAllReservationByUserId(userId);
	}
	
	/*
	 *  Get reservation by sitterId
	 */
	public List<Reservation> getReservationBySitterId(Long sitterId) {
		return reservationRepository.findAllReservationBySitterId(sitterId);
	}
	
}

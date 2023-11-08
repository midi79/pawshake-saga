package com.anderson.pawshake.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.reservation.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findAllReservationByUserId(Long userId);
	List<Reservation> findAllReservationBySitterId(Long sitterId);
}


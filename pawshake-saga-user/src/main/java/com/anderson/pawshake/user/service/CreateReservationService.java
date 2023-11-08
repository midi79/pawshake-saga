package com.anderson.pawshake.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anderson.pawshake.user.saga.ReservationSagaData;

@FeignClient(name="reservation", url = "${api.url.reservation}")
public interface CreateReservationService {
	
	@PostMapping("/create")
	Long createReservation(@RequestBody ReservationSagaData reservationData);
}

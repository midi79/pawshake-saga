package com.anderson.pawshake.user.saga;

import org.springframework.stereotype.Component;

import com.anderson.pawshake.reservation.saga.ReservationCommand;

import io.eventuate.tram.commands.consumer.CommandWithDestination;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

@Component
public class ReservationServiceProxy {
	CommandWithDestination updateReservationStatus(Long reservationId, String status) {
		return send(new ReservationCommand(reservationId, status))
				.to("reservation.service")
				.build();
	}
}

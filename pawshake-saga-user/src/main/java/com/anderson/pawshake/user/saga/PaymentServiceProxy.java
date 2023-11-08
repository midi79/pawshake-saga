package com.anderson.pawshake.user.saga;

import io.eventuate.tram.commands.consumer.CommandWithDestination;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import org.springframework.stereotype.Component;

import com.anderson.pawshake.payment.saga.PayCommand;

@Component
public class PaymentServiceProxy {
	
	CommandWithDestination payReservation(Long reservationId, Long userId, Long sitterId, Long petId, Long price) {
		return send(new PayCommand(reservationId, userId, sitterId, petId, price))
				.to("payment.service")
				.build();
	}
	
	
}

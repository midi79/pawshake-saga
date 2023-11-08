package com.anderson.pawshake.reservation.saga;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.reservation.service.ReservationService;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

@Component
public class ReservationCommandHandler {
	
	@Autowired
	private ReservationService reservationService;
	
	
	public CommandHandlers commandHandlers() {
	    return SagaCommandHandlersBuilder
	            .fromChannel("reservation.service")
	            .onMessage(ReservationCommand.class, this::updateReservationStatus)
	            .build();
	}
	
	public Message updateReservationStatus(CommandMessage<ReservationCommand> cm) {
			
		ReservationCommand cmd = cm.getCommand();
	
		try {
			reservationService.updateStatus(cmd.getReservationId(), cmd.getStatus());
			return withSuccess(new ReservationStatusUpdated());
		} catch(Exception e) {
			return withFailure(e);
		}
	}
	
}

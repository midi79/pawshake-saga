package com.anderson.pawshake.payment.saga;

import com.anderson.pawshake.payment.service.PaymentService;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentCommandHandler {
	
	@Autowired
	private PaymentService paymentService;

//	public PaymentCommandHandler(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}
	
	public CommandHandlers commandHandlers() {
	    return SagaCommandHandlersBuilder
	            .fromChannel("payment.service")
	            .onMessage(PayCommand.class, this::payReservation)
	            .build();
	}
	
	public Message payReservation(CommandMessage<PayCommand> cm) {
		PayCommand cmd = cm.getCommand();
		
		try {			
			paymentService.paymentProcess(cmd.getReservationId(), cmd.getUserId(), cmd.getSitterId(), cmd.getPetId(), cmd.getPrice());
			return withSuccess(new PaymentApproved());
		} catch(PaymentFailedException e) {
			return withFailure(new PaymentFailed());
		}
	}
	

}

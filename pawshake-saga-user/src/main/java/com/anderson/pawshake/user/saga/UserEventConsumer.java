package com.anderson.pawshake.user.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.reservation.saga.PaymentProcessed;
import com.anderson.pawshake.user.service.UserService;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class UserEventConsumer {
	
	@Autowired
	private UserService userService;
	

	public DomainEventHandlers paymentDomainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("com.anderson.pawshake.payment.domain.Payment")	            
	            .onEvent(PaymentProcessed.class, this::handlePaymentStatusUpdatedEvent)
	            .build();
	}
	
		
	private void handlePaymentStatusUpdatedEvent(DomainEventEnvelope<PaymentProcessed> domainEventEnvelope) {		
		
		PaymentProcessed event = domainEventEnvelope.getEvent();		
		
		userService.updateStatus(event.getUserId(), event.getStatus());
	
	}
	
	
}

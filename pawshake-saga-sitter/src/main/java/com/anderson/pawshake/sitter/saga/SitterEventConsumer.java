package com.anderson.pawshake.sitter.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.reservation.saga.PaymentProcessed;
import com.anderson.pawshake.reservation.saga.PendingStatusUpdated;
import com.anderson.pawshake.sitter.service.SitterService;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class SitterEventConsumer {
	
	@Autowired
	private SitterService sitterService;
	
	
	public DomainEventHandlers userDomainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("com.anderson.pawshake.user.domain.User")
	            .onEvent(PendingStatusUpdated.class, this::handlePendingStatusUpdatedEvent)
	            .build();
	}
	
	public DomainEventHandlers paymentDomainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("com.anderson.pawshake.payment.domain.Payment")
	            .onEvent(PaymentProcessed.class, this::handlePaymentStatusUpdatedEvent)
	            .build();
	}

	private void handlePendingStatusUpdatedEvent(DomainEventEnvelope<PendingStatusUpdated> domainEventEnvelope) {		
	
		PendingStatusUpdated event = domainEventEnvelope.getEvent();		
		
		sitterService.updateStatus(event.getSitterId(), event.getStatus());
	
	}	
	
	private void handlePaymentStatusUpdatedEvent(DomainEventEnvelope<PaymentProcessed> domainEventEnvelope) {		
		
		PaymentProcessed event = domainEventEnvelope.getEvent();		
		
		sitterService.updateStatus(event.getSitterId(), event.getStatus());
	
	}
	
	
	
}

package com.anderson.pawshake.reservation.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.reservation.service.ReservationService;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class ReservationEventConsumer {
	
	@Autowired
	private ReservationService reservaionService;
	
	
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
		
		reservaionService.updateStatus(event.getReservationId(), event.getStatus());
	
	}	
		
	private void handlePaymentStatusUpdatedEvent(DomainEventEnvelope<PaymentProcessed> domainEventEnvelope) {		
		
		PaymentProcessed event = domainEventEnvelope.getEvent();		
		
		reservaionService.updateStatus(event.getReservationId(), event.getStatus());
	
	}
	
	
}

package com.anderson.pawshake.payment.saga;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.payment.PawshakePaymentApplication;
import com.anderson.pawshake.payment.domain.Payment;
import com.anderson.pawshake.payment.service.PaymentService;
import com.anderson.pawshake.reservation.saga.PaymentProcessed;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class PaymentEventConsumer {
	
	@Autowired
	private PaymentService paymentService;
	
	
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("com.anderson.pawshake.user.domain.User")
	            .onEvent(PayRequested.class, this::handlePaymentProcessEvent)
	            .build();
	}

	private void handlePaymentProcessEvent(DomainEventEnvelope<PayRequested> domainEventEnvelope) {		
	
		PayRequested event = domainEventEnvelope.getEvent();		
		
		Payment payment = paymentService.paymentChoreographyProcess(event.getReservationId(), event.getUserId(), event.getSitterId(), event.getPetId(), event.getPrice());
		
		UpdateStatus(payment);
	}	
	
	
	public void UpdateStatus(Payment payment) {
		DomainEventPublisher publisher = PawshakePaymentApplication.applicationContext.getBean(DomainEventPublisher.class);
		
		PaymentProcessed paymentProcessed = new PaymentProcessed(payment.getStatus(), payment.getReservationId(), payment.getUserId(), payment.getSitterId(), payment.getPetId());
		
		publisher.publish(Payment.class, payment.getId(), Collections.singletonList(paymentProcessed));
	}
	
	
}

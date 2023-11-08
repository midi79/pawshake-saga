package com.anderson.pawshake.user.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.user.PawshakeUserApplication;
import com.anderson.pawshake.user.domain.User;
import com.anderson.pawshake.payment.saga.PayRequested;
import com.anderson.pawshake.reservation.saga.PendingStatusUpdated;
import com.anderson.pawshake.user.saga.ReservationSagaData;

import io.eventuate.tram.events.publisher.DomainEventPublisher;


@Service
public class UserChoreographySagaService {
		
	private ReservationSagaData sagaData;
	
	private final String PAY_PENDING = "PAY_PENDING";
	
	@Autowired
	UserService userService;
	
	
	public void UpdateStatusPending() {
		DomainEventPublisher publisher = PawshakeUserApplication.applicationContext.getBean(DomainEventPublisher.class);
		
		sagaData = userService.createReservationData();
		sagaData.setId(userService.createReservation(sagaData));
		
		userService.updateStatus(sagaData.getUserId(), PAY_PENDING);
		
		PendingStatusUpdated pendingStatusUpdated = new PendingStatusUpdated(sagaData.getId(), sagaData.getSitterId());
		publisher.publish(User.class, sagaData.getUserId(), Collections.singletonList(pendingStatusUpdated));		
	}	
	
		
	public void requestPay() {
		DomainEventPublisher publisher = PawshakeUserApplication.applicationContext.getBean(DomainEventPublisher.class);
		
		PayRequested payRequested = new PayRequested(sagaData.getId(), sagaData.getUserId(), sagaData.getSitterId(), sagaData.getPetId(), sagaData.getPrice());
		publisher.publish(User.class, sagaData.getUserId(), Collections.singletonList(payRequested));
	}
	
	
}


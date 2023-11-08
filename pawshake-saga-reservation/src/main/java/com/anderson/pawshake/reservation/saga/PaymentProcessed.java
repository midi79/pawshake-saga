package com.anderson.pawshake.reservation.saga;

import io.eventuate.tram.events.common.DomainEvent;

public class PaymentProcessed implements DomainEvent {

	private String status;
	
	private Long reservationId;

	private Long userId;

	private Long sitterId;
	
	private Long petId;
	
	public PaymentProcessed() {		
	}
	
	public PaymentProcessed(String status, Long reservationId, Long userId, Long sitterId, Long petId) {
		this.status = status;
		this.reservationId = reservationId;
		this.userId = userId;
		this.sitterId = sitterId;
		this.petId = petId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSitterId() {
		return sitterId;
	}

	public void setSitterId(Long sitterId) {
		this.sitterId = sitterId;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}
}

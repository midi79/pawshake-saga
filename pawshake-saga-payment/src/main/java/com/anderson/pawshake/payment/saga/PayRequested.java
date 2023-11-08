package com.anderson.pawshake.payment.saga;

import io.eventuate.tram.events.common.DomainEvent;

public class PayRequested implements DomainEvent {
	
	private Long reservationId;

	private Long userId;

	private Long sitterId;
	
	private Long petId;
	
	private Long price;
	
	
	public PayRequested() {		
	}

	public PayRequested(Long reservationId, Long userId, Long sitterId, Long petId, Long price) {
		this.reservationId = reservationId;
		this.userId = userId;
		this.sitterId = sitterId;
		this.petId = petId;
		this.price = price;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	

}
 
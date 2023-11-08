package com.anderson.pawshake.reservation.saga;

import io.eventuate.tram.events.common.DomainEvent;

public class PendingStatusUpdated implements DomainEvent {
	
	private final String PAY_PENDING = "PAY_PENDING";
	
	private Long reservationId;
	
	private Long sitterId;
	
	private String status;

	public PendingStatusUpdated() {		
	}
	
	public PendingStatusUpdated(Long reservationId, Long sitterId) {
		this.reservationId = reservationId;
		this.sitterId = sitterId;
		this.status = PAY_PENDING;
	}
	
	@Override
	public String toString() {
		return "PendingStatusUpdated [reservationId=" + reservationId + ", sitterId=" + sitterId + ", status=" + status
				+ "]";
	}

	
	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getSitterId() {
		return sitterId;
	}

	public void setSitterId(Long sitterId) {
		this.sitterId = sitterId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}

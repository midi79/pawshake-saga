package com.anderson.pawshake.reservation.saga;

import io.eventuate.tram.commands.common.Command;

public class ReservationCommand implements Command {

	private Long reservationId;
	
	private String status;

	
	public ReservationCommand() {		
	}	
	
	public ReservationCommand(Long reservationId, String status) {
		this.reservationId = reservationId;
		this.status = status;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

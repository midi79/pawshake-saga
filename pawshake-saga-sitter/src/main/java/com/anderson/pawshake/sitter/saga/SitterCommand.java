package com.anderson.pawshake.sitter.saga;

import io.eventuate.tram.commands.common.Command;

public class SitterCommand implements Command {

	private Long sitterId;
	
	private String status;
	
	
	public SitterCommand() {		
	}	

	public SitterCommand(Long sitterId, String status) {
		this.sitterId = sitterId;
		this.status = status;
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

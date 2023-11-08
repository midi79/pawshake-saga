package com.anderson.pawshake.payment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.MappedSuperclass;
import javax.persistence.EntityListeners;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity implements Serializable {
    	
	private static final long serialVersionUID = -5207143929377682165L;
		
	@LastModifiedDate
    private LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
		
}


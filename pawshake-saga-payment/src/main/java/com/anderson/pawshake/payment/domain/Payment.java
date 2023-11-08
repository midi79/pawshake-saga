package com.anderson.pawshake.payment.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment extends BaseTimeEntity implements Serializable {

	private static final long serialVersionUID = -7000383705554608425L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "status")
	private String status;
	
	@NotNull
	@Column(name = "reservation_id")
	private Long reservationId;

	@NotNull
	@Column(name = "user_id")
	private Long userId;

	@NotNull
	@Column(name = "sitter_id")
	private Long sitterId;
	
	@NotNull
	@Column(name = "pet_id")
	private Long petId;
	
	@NotNull
	@Column(name = "price")
	private Long price;
				
	public Payment() {		
	}	
	
	public Payment(PaymentDto payment) {
		this.status = payment.getStatus();
		this.reservationId = payment.getReservationId();
		this.userId = payment.getUserId();		
		this.sitterId = payment.getSitterId();		
		this.petId = payment.getPetId();
		this.price = payment.getPrice();				
	}
	
	public static Payment createPayment(PaymentDto payment) {
		return new Payment(payment);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

				
}

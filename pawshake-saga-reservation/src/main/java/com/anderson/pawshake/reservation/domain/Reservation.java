package com.anderson.pawshake.reservation.domain;

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
@Table(name="tb_reservation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation extends BaseTimeEntity implements Serializable {
	
	private static final long serialVersionUID = -7098001229852183384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "status")
	private String status;

	@NotNull
	@Column(name = "service_type")
	private String serviceType;
	
	@NotNull
	@Column(name = "from_date")
	private String fromDate;
	
	@NotNull
	@Column(name = "to_Date")
	private String toDate;
	
	@NotNull
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@NotNull
	@Column(name = "pet_id")
	private Long petId;
	
	@NotNull
	@Column(name = "pet_name")
	private String petName;
		
	@NotNull
	@Column(name = "sitter_id")
	private Long sitterId;
	
	@NotNull
	@Column(name = "sitter_name")
	private String sitterName;
	
	@NotNull
	@Column(name = "price")
	private Long price;
		
		
	public Reservation() {		
	}	
	
	public Reservation(ReservationDto reservation) {
		this.status = reservation.getStatus();		
		this.serviceType = reservation.getUserName();
		this.fromDate = reservation.getFromDate();
		this.toDate = reservation.getToDate();
		this.userId = reservation.getUserId();
		this.userName = reservation.getUserName();
		this.petId = reservation.getPetId();
		this.petName = reservation.getPetName();
		this.sitterId = reservation.getSitterId();
		this.sitterName = reservation.getSitterName();
		this.price = reservation.getPrice();
	}
	
	public static Reservation createReservation(ReservationDto reservation) {
		return new Reservation(reservation);
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Long getSitterId() {
		return sitterId;
	}

	public void setSitterId(Long sitterId) {
		this.sitterId = sitterId;
	}

	public String getSitterName() {
		return sitterName;
	}

	public void setSitterName(String sitterName) {
		this.sitterName = sitterName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
				
}

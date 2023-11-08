package com.anderson.pawshake.user.saga;

public class ReservationSagaData {

	private Long id;
	
	private String status;

	private String serviceType;
	
	private String fromDate;
	
	private String toDate;
	
	private Long userId;
	
	private String userName;
	
	private Long petId;
	
	private String petName;
		
	private Long sitterId;
	
	private String sitterName;
	
	private Long price;
		
	
	public ReservationSagaData() {		
	}
	
	public ReservationSagaData(String status, String serviceType, String fromDate, String toDate, Long userId,
			String userName, Long petId, String petName, Long sitterId, String sitterName, Long price) {
		this.status = status;
		this.serviceType = serviceType;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.userId = userId;
		this.userName = userName;
		this.petId = petId;
		this.petName = petName;
		this.sitterId = sitterId;
		this.sitterName = sitterName;
		this.price = price;
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

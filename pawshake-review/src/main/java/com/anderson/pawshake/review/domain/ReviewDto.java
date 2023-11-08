package com.anderson.pawshake.review.domain;

public class ReviewDto {
	
	private Long id;
	
	private Long reservationId;

	private Long userId;
	
	private String userName;
	
	private Long sitterId;
	
	private String sitterName;
	
	private Long rating;

	private String comment;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
			
}

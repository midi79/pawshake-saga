package com.anderson.pawshake.review.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_review")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review extends BaseTimeEntity implements Serializable {

	private static final long serialVersionUID = -7568011848354170563L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "reservation_id")
	private Long reservationId;

	@NotNull
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@NotNull
	@Column(name = "sitter_id")
	private Long sitterId;
	
	@NotNull
	@Column(name = "sitter_name")
	private String sitterName;
	
	@Column(name = "rating")
	private Long rating;
			
	@Column(name = "comment")
	private String comment;
			
	public Review() {		
	}	
	
	public Review(ReviewDto review) {
		this.reservationId = review.getReservationId();
		this.userId = review.getUserId();
		this.userName = review.getUserName();
		this.sitterId = review.getSitterId();
		this.sitterName = review.getSitterName();
		this.rating = review.getRating();
		this.comment = review.getComment();
	}
	
	public static Review createReview(ReviewDto review) {
		return new Review(review);
	}

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

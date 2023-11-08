package com.anderson.pawshake.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.review.domain.Review;
import com.anderson.pawshake.review.domain.ReviewDto;
import com.anderson.pawshake.review.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	/*
	 * Create review
	 */
	public Review createReview(ReviewDto review) {				
		Review newReview = Review.createReview(review);		
		
		return reviewRepository.save(newReview);
	}

	/*
	 * Modify review information
	 */
	public Review updateReview(ReviewDto review) {
		Review originReview = reviewRepository.findById(review.getId()).orElseThrow();
				
		originReview.setReservationId(review.getReservationId());
		originReview.setUserId(review.getUserId());
		originReview.setUserName(review.getUserName());
		originReview.setSitterId(review.getSitterId());
		originReview.setSitterName(review.getSitterName());
		originReview.setRating(review.getRating());
		originReview.setComment(review.getComment());
		
		return reviewRepository.save(originReview);
	}

	/*
	 * Search review
	 */		
	public Review findById(Long id) {
		return reviewRepository.findById(id).orElse(null);
	}
	
	/*
	 *  Get all review
	 */	
	public List<Review> getAllReview() {
		return reviewRepository.findAll();
	}
	
	/*
	 *  Get review by userId
	 */
	public List<Review> getReviewByUserId(Long userId) {
		return reviewRepository.findAllReviewByUserId(userId);
	}
	
	/*
	 *  Get review by sitterId
	 */
	public List<Review> getReviewBySitterId(Long sitterId) {
		return reviewRepository.findAllReviewBySitterId(sitterId);
	}
	
}

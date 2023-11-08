package com.anderson.pawshake.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.review.domain.Review;
import com.anderson.pawshake.review.domain.ReviewDto;
import com.anderson.pawshake.review.service.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createReview(@RequestBody final ReviewDto review) {

		Review newReview = reviewService.createReview(review);
		
		return ResponseEntity.ok(newReview.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Review> getReview(@PathVariable final Long id) {

		Review review = reviewService.findById(id);
		
		return ResponseEntity.ok(review);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<Review>> getAllReview() {

		return ResponseEntity.ok(reviewService.getAllReview());
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Review>> getAllReviewByUser(@PathVariable final Long userId) {

		return ResponseEntity.ok(reviewService.getReviewByUserId(userId));
	}


	@GetMapping("/sitter/{sitterId}")
	public ResponseEntity<List<Review>> getAllReviewBySitter(@PathVariable final Long sitterId) {

		return ResponseEntity.ok(reviewService.getReviewBySitterId(sitterId));
	}

	
}

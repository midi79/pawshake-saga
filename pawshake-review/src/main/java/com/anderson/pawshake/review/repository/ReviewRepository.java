package com.anderson.pawshake.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findAllReviewByUserId(Long userId);
	List<Review> findAllReviewBySitterId(Long sitterId);
}
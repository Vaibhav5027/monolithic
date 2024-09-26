package com.microservices.service;

import java.util.List;

import com.microservices.model.Review;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);
	
	Review getReviewById(Long id,Long reviewId);
	
	String updateReview(Long id,Long reviewId,Review review);
	
	String addReview(Long companyId,Review review);
	
	String deleteReview(Long id,Long reviewId);
}

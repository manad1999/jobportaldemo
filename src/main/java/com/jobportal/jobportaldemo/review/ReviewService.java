package com.jobportal.jobportaldemo.review;

import java.util.List;

public interface ReviewService {
	
	public List<Review> getAllReviews(Long companyId);
	public boolean addReview(Long companyId, Review review);
	public Review getReview(Long companyId, Long reviewId);

}

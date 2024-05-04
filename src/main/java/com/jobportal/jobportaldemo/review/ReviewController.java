package com.jobportal.jobportaldemo.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService)
	{
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
	{
		List<Review> reviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review)
	{
		boolean isAdded = reviewService.addReview(companyId, review);
		if(isAdded)
			return new ResponseEntity<String>("Review Added Successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Company Not found", HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId)
	{
		Review getReview = reviewService.getReview(companyId, reviewId);
		
		if(getReview != null)
		{
			return new ResponseEntity<Review>(getReview, HttpStatus.OK);
		}
		return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}

}

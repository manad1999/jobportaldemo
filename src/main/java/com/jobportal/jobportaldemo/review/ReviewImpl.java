package com.jobportal.jobportaldemo.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.jobportaldemo.company.Company;
import com.jobportal.jobportaldemo.company.CompanyService;

@Service
public class ReviewImpl implements ReviewService {
	private ReviewRespository reviewRespository;
	private CompanyService companyService;


	public ReviewImpl(ReviewRespository reviewRespository,CompanyService companyService) {
		this.reviewRespository = reviewRespository;
		this.companyService = companyService;
	}


	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRespository.findByCompanyId(companyId);
		return reviews;
	}


	@Override
	public boolean addReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompany(companyId);
		if(company != null)
		{
			review.setCompany(company);
			reviewRespository.save(review);
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public Review getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRespository.findByCompanyId(companyId);
		
		return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
		
	}


	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review newreview) {
		if(companyService.getCompany(companyId) != null)
		{
			newreview.setCompany(companyService.getCompany(companyId));
			newreview.setId(reviewId);
			reviewRespository.save(newreview);
			return true;
		}
		return false;
	}


	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.getCompany(companyId) != null && reviewRespository.existsById(reviewId) 
				&& reviewRespository.findById(reviewId).get().getCompany().getId() == companyId)
		{
			Review deleteReview = reviewRespository.findById(reviewId).get();
			reviewRespository.delete(deleteReview);
			return true;
			
		}
		return false;
	}
	

}

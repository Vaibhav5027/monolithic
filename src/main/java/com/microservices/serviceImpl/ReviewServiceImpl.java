package com.microservices.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.Company;
import com.microservices.model.Review;
import com.microservices.repo.CompanyRepository;
import com.microservices.repo.ReviewRepository;
import com.microservices.service.CompanyService;
import com.microservices.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private CompanyService compService;

	@Override
	public List<Review> getAllReviews(Long companyId) {

		return reviewRepo.findByCompanyCompanyId(companyId);
	}

	@Override
	public String addReview(Long companyId, Review review) {
		if (companyRepo.existsById(companyId)) {
			Company company = companyRepo.findById(companyId).get();
			review.setCompany(company);
			reviewRepo.save(review);
			return "review added succefully";
		} else {
			return "company not found";
		}

	}

	@Override
	public String updateReview(Long id, Long reviewId, Review review) {
		if (companyRepo.existsById(id)) {
			Company company = companyRepo.findById(reviewId).get();
			review.setCompany(company);
			review.setReviewId(reviewId);
			reviewRepo.save(review);
			return "review updated succefully";
		}
		return "Not Found";
	}

	@Override
	public String deleteReview(Long id, Long reviewId) {
		Company company = companyRepo.findById(id).get();
		if (company != null && reviewRepo.existsById(reviewId)) {
			companyRepo.findById(id).get();
			Review review = reviewRepo.findById(reviewId).get();
			company.getReviews().remove(review);
			compService.updateCompany(id, company);
			reviewRepo.deleteById(reviewId);
			return "review deleted succesfully";

		}
		return "not found";
	}

	@Override
	public Review getReviewById(Long id, Long reviewId) {
		if (companyRepo.existsById(id)) {
			List<Review> reviews = reviewRepo.findByCompanyCompanyId(id);
			Review review = reviews.stream().filter(rev -> rev.getReviewId().equals(reviewId)).findFirst().get();
			return review;
		} else {
			return null;
		}

	}

}

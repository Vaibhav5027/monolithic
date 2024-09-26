package com.microservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  List<Review> findByCompanyCompanyId(Long companyId);
}

package com.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.Company;

public interface CompanyRepository extends JpaRepository<Company ,Long> {

}

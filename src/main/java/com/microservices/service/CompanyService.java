package com.microservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.microservices.model.Company;

public interface CompanyService {

	ResponseEntity<List<Company>> getAllCompanies();

	ResponseEntity<String> updateCompany(Long id, Company company);
	
	ResponseEntity<Company> addCompany(Company company);
	
	ResponseEntity<String> deleteCompanyById(Long id);
	
	ResponseEntity<Company> companyById(Long id);

}

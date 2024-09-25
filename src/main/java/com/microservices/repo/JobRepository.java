package com.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}

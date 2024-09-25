package com.microservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.microservices.model.Job;

public interface JobService {
  
 public ResponseEntity<List<Job>>  findAllJobs();

public ResponseEntity<String> cretaJob(Job job);	

public ResponseEntity<Job> findById(int id);

public ResponseEntity<String> deleteById(int id);

public ResponseEntity<String> updateJob(int id,Job job);
}

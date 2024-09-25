package com.microservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Job;
import com.microservices.service.JobService;

@RestController
@RequestMapping("api/job/")
public class JobController {

	@Autowired
	private JobService jobService;

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	@GetMapping("getalljob")
	public ResponseEntity<List<Job>> findAll() {
		logger.info("inside controller {}");
		System.out.println("inside job");
		return jobService.findAllJobs();
	}

	@PostMapping("add")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		logger.info("inside controller {}");
		return jobService.cretaJob(job);
	}

	@GetMapping("jobbyid/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable int id) {
		logger.info("inside controller {}");
		System.out.println("inside job");
		return jobService.findById(id);
	}

	@PostMapping("deletebyid/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable int id) {
		logger.info("inside controller {}");
		return jobService.deleteById(id);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Job job) {
		logger.info("inside controller {}");
		return jobService.updateJob(id,job);
	}

}

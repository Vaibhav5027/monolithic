package com.microservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String title;
	private String description;
	private String maxSalary;
	private String minSalary;
	private String location;

	@ManyToOne
	private Company company;

	public Job() {

	}

	public Job(int jobId, String title, String description, String maxSalary, String minSalary, String location,
			Company company) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.description = description;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.location = location;
		this.company = company;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", description=" + description + ", maxSalary=" + maxSalary
				+ ", minSalary=" + minSalary + ", location=" + location + ", company=" + company + "]";
	}

}

package com.jobportal.jobportaldemo.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> getJobs()
	{
		List<Job> jobs = jobService.findAll();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Job> postJob(@RequestBody Job job)
	{
		System.out.println(job.toString());
		Job addedJob = jobService.postJob(job);
		return new ResponseEntity<>(addedJob, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Job> putJob(@PathVariable long id)
	{
		return null;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Job> deleteJob(@PathVariable long id)
	{
		return null;
		
	}

}

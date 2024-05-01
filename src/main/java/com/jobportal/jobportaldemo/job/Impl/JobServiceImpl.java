package com.jobportal.jobportaldemo.job.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.jobportaldemo.job.Job;
import com.jobportal.jobportaldemo.job.JobService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class JobServiceImpl implements JobService{
	
	private JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		
		return jobRepository.findAll();
	}

	@Override
	public Job getJob(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Job postJob(Job job) {
		Job addedjob = jobRepository.postJob(job);
		return addedjob;
	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteJob(Long id) {
		// TODO Auto-generated method stub
		
	}

}

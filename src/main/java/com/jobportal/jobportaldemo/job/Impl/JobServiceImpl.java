package com.jobportal.jobportaldemo.job.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.jobportaldemo.job.Job;
import com.jobportal.jobportaldemo.job.JobRepository;
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
		Job job = jobRepository.findById(id).get();
		return job;
	}

	@Override
	@Transactional
	public Job postJob(Job job) {
		Job addedjob = jobRepository.save(job);
		return addedjob;
	}
	@Transactional
	@Override
	public Job updateJob(Long id, Job job) {
		
		Job toUpdateJob = jobRepository.findById(id).get();
		if(toUpdateJob ==  null)
			return null;
		else
		{
			toUpdateJob.setTitle(job.getTitle());
			toUpdateJob.setDescription(job.getDescription());
			toUpdateJob.setLocation(job.getLocation());
			toUpdateJob.setMinSalary(job.getMinSalary());
			toUpdateJob.setMaxSalary(job.getMaxSalary());
			jobRepository.save(toUpdateJob);
			
			return toUpdateJob;
		}
	}

	@Transactional
	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		try
		{
			jobRepository.deleteById(id);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

}

package com.jobportal.jobportaldemo.job;

import java.util.List;

public interface JobService {
	
	public List<Job> findAll();
	
	public Job getJob(Long id);
	
	public Job postJob(Job job);
	
	public Job updateJob(Long id, Job job);
	
	public boolean deleteJob(Long id);

}

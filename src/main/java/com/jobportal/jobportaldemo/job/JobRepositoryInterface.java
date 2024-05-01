package com.jobportal.jobportaldemo.job;

import java.util.List;

public interface JobRepositoryInterface {
	
public List<Job> findAll();
	
	public Job getJob(Long id);
	
	public Job postJob(Job job);
	
	public Job updateJob(Job job);
	
	public void deleteJob(Long id);
}

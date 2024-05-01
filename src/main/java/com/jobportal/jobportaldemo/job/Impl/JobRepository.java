package com.jobportal.jobportaldemo.job.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.jobportaldemo.job.Job;
import com.jobportal.jobportaldemo.job.JobRepositoryInterface;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class JobRepository implements JobRepositoryInterface {

	private EntityManager entityManager;
	
	
	public JobRepository(EntityManager entityManager) {

		this.entityManager = entityManager;
	}
	
	@Override
	public List<Job> findAll() {
		String findall_jpql = "SELECT j FROM Job j";
		TypedQuery<Job> query =  entityManager.createQuery(findall_jpql, Job.class);
		return query.getResultList();
	}

	@Override
	public Job getJob(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job postJob(Job job) {
		
		Job addedjob = entityManager.merge(job);
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

package org.socialnetworking.dao;

import java.util.List;

import org.socialnetworking.model.Job;

public interface IJobDAO  {

	boolean saveOrUpdate(Job job);

	boolean delete(Job job);

	Job get(int jobId);

	List<Job> list();
	
	Job getByJobProfile(String jobProfile);
}

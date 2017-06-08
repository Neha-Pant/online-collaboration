package org.socialnetworking.dao;

import java.util.List;

import org.socialnetworking.model.*;

public interface JobAppliedDAO {


	boolean saveOrUpdate(JobApplied jobApplied);

	boolean delete(JobApplied jobApplied);

	JobApplied get(int id);

	List<JobApplied> list();
}

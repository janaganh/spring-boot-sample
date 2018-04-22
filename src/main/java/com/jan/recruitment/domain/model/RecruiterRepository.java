package com.jan.recruitment.domain.model;


import java.util.List;


/**
 * Created by jhe on 4/21/2018.
 */
public interface RecruiterRepository {
	List<Recruiter> findAll();
}

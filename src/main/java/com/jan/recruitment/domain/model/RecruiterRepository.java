package com.jan.recruitment.domain.model;


import java.util.List;

import com.jan.recruitment.domain.model.Recruiter;

/**
 * Created by jhe on 4/21/2018.
 */
public interface RecruiterRepository {
	List<Recruiter> findAll();
}

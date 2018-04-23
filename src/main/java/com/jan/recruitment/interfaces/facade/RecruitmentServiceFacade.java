package com.jan.recruitment.interfaces.facade;

import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;

import java.util.List;

/**
 * Created by jhe on 4/21/2018.
 */
public interface RecruitmentServiceFacade {
	List<RecruiterDto> listAllRecruiters();

	double calculateCommission(long recruiterId);
}

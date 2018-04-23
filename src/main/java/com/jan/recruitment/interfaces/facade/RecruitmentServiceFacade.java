package com.jan.recruitment.interfaces.facade;

import com.jan.recruitment.domain.model.Personal;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;

import java.util.List;

/**
 * Created by jhe on 4/21/2018.
 */
public interface RecruitmentServiceFacade {
	List<RecruiterDto> listAllRecruiters();

	List<PersonalDto> listPersonal(long recruiterId);

	double calculateCommission(long recruiterId);
}

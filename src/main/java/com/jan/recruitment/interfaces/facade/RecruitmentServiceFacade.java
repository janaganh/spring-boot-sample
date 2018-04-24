package com.jan.recruitment.interfaces.facade;

import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RecruitmentServiceFacade {
	List<RecruiterDto> listAllRecruiters();

	List<PersonalDto> listPersonal(long recruiterId);

	double calculateCommission(long recruiterId);
}

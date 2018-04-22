package com.jan.recruitment.interfaces.facade.internal;

import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruiterRepository;
import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jhe on 4/21/2018.
 */
@ApplicationScope
public class RecruiterServiceFacadeImpl implements RecruitmentServiceFacade {

	@Inject
	private RecruiterRepository reccuitmentRepository;

	@Override
	public List<RecruiterDto> listAllRecruiters() {
		List<Recruiter> recruiterList = reccuitmentRepository.findAll();
		RecruiterDtoAssembler recruiterDtoAssembler = new RecruiterDtoAssembler();
		return recruiterDtoAssembler.toDtoList(recruiterList);
	}
}

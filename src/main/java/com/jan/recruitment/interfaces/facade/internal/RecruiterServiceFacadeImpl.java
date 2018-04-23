package com.jan.recruitment.interfaces.facade.internal;

import com.jan.recruitment.appliction.CalculationService;
import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruitmentTransactionRepository;
import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruiterRepository;
import java.util.List;

@ApplicationScope
@Service
public class RecruiterServiceFacadeImpl implements RecruitmentServiceFacade {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private JpaRecruiterRepository recruitmentRepository;

	@Autowired
	private JpaRecruitmentTransactionRepository recruitmentTransactionRepository;

	@Autowired
	private JpaRecruiterRepository recruiterRepository;

	@Override
	public List<RecruiterDto> listAllRecruiters() {
		List<Recruiter> recruiterList = recruitmentRepository.findAll();
		RecruiterDtoAssembler recruiterDtoAssembler = new RecruiterDtoAssembler();
		return recruiterDtoAssembler.toDtoList(recruiterList);
	}

	@Override
	public double calculateCommission(final long recruiterId) {
		return  calculationService.calculateCommission(recruiterId);
	}

}

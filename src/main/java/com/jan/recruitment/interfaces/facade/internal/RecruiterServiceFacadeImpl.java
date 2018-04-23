package com.jan.recruitment.interfaces.facade.internal;

import com.jan.recruitment.appliction.CalculationService;
import com.jan.recruitment.domain.model.Personal;
import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruitmentTransactionRepository;
import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruiterRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScope
@Service
public class RecruiterServiceFacadeImpl implements RecruitmentServiceFacade {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private JpaRecruiterRepository recruiterRepository;

	@Autowired
	private JpaRecruitmentTransactionRepository transactionRepository;


	@Override
	public List<RecruiterDto> listAllRecruiters() {
		List<Recruiter> recruiterList = recruiterRepository.findAll();
		RecruiterDtoAssembler recruiterDtoAssembler = new RecruiterDtoAssembler();
		return recruiterDtoAssembler.toDtoList(recruiterList);
	}

	@Override
	public List<PersonalDto> listPersonal(long recruiterId) {
		LocalDate today = LocalDate.now();
		Date fromDate = java.sql.Date.valueOf(today.withDayOfMonth(1));
		Date toDate = java.sql.Date.valueOf(today.withDayOfMonth(today.lengthOfMonth()));

		PersonalDtoAssembler personalDtoAssembler = new PersonalDtoAssembler();

		List<RecruitmentTransaction> transactionList = transactionRepository.findByRecruiter(recruiterId, fromDate, toDate);
		List<PersonalDto> personalList = new ArrayList<>();
		transactionList.forEach(transaction -> {
			personalList.addAll(personalDtoAssembler.toDtoList(new ArrayList<>(transaction.getPersonals())));
		});
		return personalList;
	}

	@Override
	public double calculateCommission(final long recruiterId) {
		return  calculationService.calculateCommission(recruiterId);
	}
}

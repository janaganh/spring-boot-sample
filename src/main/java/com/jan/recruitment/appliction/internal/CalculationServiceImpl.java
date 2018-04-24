package com.jan.recruitment.appliction.internal;

import com.jan.recruitment.appliction.CalculationService;
import com.jan.recruitment.appliction.util.CalculationHelper;
import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaCommissionRepository;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruitmentTransactionRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.time.LocalDate;
import java.util.List;


/*
 This class contains the logic for calculating the commission for recruiters
*/


@Service
public class CalculationServiceImpl implements CalculationService{
	@Setter
	@Autowired
	private JpaRecruitmentTransactionRepository recruitmentTransactionRepository;

	@Setter
	@Autowired
	private JpaCommissionRepository commissionRepository;

	@Override
	public double calculateCommission(final long recruiterId) {

		final CalculationHelper calculationHelper = new CalculationHelper();
		LocalDate today = LocalDate.now();
		Date fromDate = java.sql.Date.valueOf(today.withDayOfMonth(1));
		Date toDate = java.sql.Date.valueOf(today.withDayOfMonth(today.lengthOfMonth()));
		List<Commission> commissionList = commissionRepository.findAll();

		List<RecruitmentTransaction> recruitmentTransactionList =
				recruitmentTransactionRepository.findByRecruiter(recruiterId, fromDate, toDate);

		recruitmentTransactionList.forEach(
			transaction -> {
				commissionList.forEach(
					commission  -> {
						long personalCount = recruitmentTransactionRepository
									.countByProfession(transaction.getId(), commission.getProfession().getId());

						calculationHelper.addAmount(this.calculatePayment(commission, personalCount));
				});

			}
		);
		return calculationHelper.getFinalAmount();
	}

	private double calculatePayment(final Commission commission, final long count) {
		// calculate payment
		double result = commission.getUnitPaymentAmount() * count;
		long multiple = count / commission.getGroupNos();
		// commission
		result += result * commission.getCommissionRate() * multiple;

		return  result;
	}
}

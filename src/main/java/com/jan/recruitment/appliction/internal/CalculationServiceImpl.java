package com.jan.recruitment.appliction.internal;

import com.jan.recruitment.appliction.CalculationService;
import com.jan.recruitment.appliction.util.CalculationHelper;
import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaCommissionRepository;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruitmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by jhe on 4/23/2018.
 */
@Service
public class CalculationServiceImpl implements CalculationService{
	@Autowired
	private JpaRecruitmentTransactionRepository recruitmentTransactionRepository;

	@Autowired
	private JpaCommissionRepository commissionRepository;

	@Override
	public double calculateCommission(long recruiterId) {

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

	protected double calculatePayment(Commission commission, long count) {
		// calculate payment
		double result = commission.getUnitPaymentAmount() * count;
		long multiple = count / commission.getGroupNos();
		// commission
		result += result * commission.getCommissionRate() * multiple;

		return  result;
	}
}

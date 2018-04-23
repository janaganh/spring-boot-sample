package com.jan.recruitment.appliction.internal;

import com.jan.recruitment.appliction.CalculationService;
import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.Personal;
import com.jan.recruitment.domain.model.Profession;
import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaCommissionRepository;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaRecruitmentTransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class CalculationServiceImplTest {

	@MockBean
	JpaRecruitmentTransactionRepository recruitmentTransactionRepository;

	@MockBean
	JpaCommissionRepository commissionRepository;

	private CalculationService calculationService = new CalculationServiceImpl();


	public void setUp() throws Exception {
		Profession p1 = new Profession(1l,"A");
		Profession p2 =  new Profession(2l,"B");

		Commission c1 = new Commission(1l, p1, 5, 200, 0.1);
		Commission c2 = new Commission(1l, p2, 5, 250, 0.1);
		List<Commission> commissionList = new ArrayList(){{
			add(c1);
			add(c2);
		}};
		when(commissionRepository.findAll()).thenReturn(commissionList);

		Date today = new Date();

		Set<Personal> personalSet1 = new HashSet(){{
			add(new Personal(1l, "A", p1));
			add(new Personal(2l, "A", p1));
			add(new Personal(3l, "A", p1));
			add(new Personal(4l, "A", p1));
			add(new Personal(5l, "A", p1));
			add(new Personal(6l, "A", p2));
		}};

		RecruitmentTransaction rt1 = new RecruitmentTransaction(1l, new Recruiter(1l, "ABC"), today, personalSet1);
		List<RecruitmentTransaction> rt1l1 = new ArrayList(){{add(rt1);}};
		when(recruitmentTransactionRepository.findByRecruiter(1l,today,today)).thenReturn(rt1l1);

		Set<Personal> personalSet2 = new HashSet(){{
			add(new Personal(7l, "A", p2));
		}};

		RecruitmentTransaction rt2 = new RecruitmentTransaction(1l, new Recruiter(2l, "ACME"), today, personalSet2);
		List<RecruitmentTransaction> rt2l2 = new ArrayList(){{add(rt2);}};
		when(recruitmentTransactionRepository.findByRecruiter(2l,today,today)).thenReturn(rt2l2);

	}

	@Test
	public void shouldCalculateCommissionCorrectly() throws Exception {
		setUp();
		double result1  = calculationService.calculateCommission(1l);
		double result2 = calculationService.calculateCommission(2l);

		assertEquals(1350, result1);
		assertEquals(250, result2);
	}

	@Test public void calculatePayment() throws Exception {

	}

}
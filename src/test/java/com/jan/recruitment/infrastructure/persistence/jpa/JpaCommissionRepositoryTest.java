package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.Profession;
import com.jan.recruitment.infrastructure.persistence.jpa.JpaCommissionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class JpaCommissionRepositoryTest {
	@MockBean
	private JpaCommissionRepository commissionRepository;

	@Test
	public void whenFindAllThenReturnList() {
		Profession profession1 = new Profession(1l, "a");
		Profession profession2 = new Profession(2l, "a");

		Commission commission1 = new Commission();
		Commission commission2 = new Commission();
		commission1.setId(1l);
		commission1.setCommissionRate(1);
		commission1.setGroupNos(1);
		commission1.setProfession(profession1);
		commission1.setUnitPaymentAmount(1);

		commission1.setId(2l);
		commission2.setCommissionRate(1);
		commission2.setGroupNos(1);
		commission2.setProfession(profession2);
		commission2.setUnitPaymentAmount(1);

		List<Commission> commissionList = new ArrayList<>();
		commissionList.add(commission1);
		commissionList.add(commission2);

		Mockito.when(commissionRepository.findAll())
				.thenReturn(commissionList);

		List<Commission> result = commissionRepository.findAll();
		assertEquals(2, commissionList.size());
		assertTrue(commissionList.contains(commission1));
		assertTrue(commissionList.contains(commission2));

	}
}
package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.Profession;
import com.jan.recruitment.domain.model.Recruiter;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class JpaRecruiterRepositoryTest {


	@MockBean
	private JpaRecruiterRepository recruiterRepository;

	@Test
	public void whenFindAllThenReturnList() {
		Recruiter r1 = new Recruiter(1l, "a");
		Recruiter r2 = new Recruiter(2l, "b");

		List<Recruiter> recruiterList = new ArrayList<>();
		recruiterList.add(r1);
		recruiterList.add(r2);

		Mockito.when(recruiterRepository.findAll())
				.thenReturn(recruiterList);

		List<Recruiter> result = recruiterRepository.findAll();
		assertEquals(2, result.size());
		assertTrue(result.contains(r1));
		assertTrue(result.contains(r2));

	}
}
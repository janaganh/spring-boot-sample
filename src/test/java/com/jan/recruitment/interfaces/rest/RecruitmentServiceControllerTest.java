package com.jan.recruitment.interfaces.rest;

import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(RecruitmentServiceController.class)
public class RecruitmentServiceControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RecruitmentServiceFacade recruitmentServiceFacade;


	@Test public void listRecruiters() throws Exception {
		RecruiterDto recruiter = new RecruiterDto(1, "A");
		List<RecruiterDto> recruiterList = Arrays.asList(recruiter);
		given(recruitmentServiceFacade.listAllRecruiters()).willReturn(recruiterList);

		mvc.perform(get("/recruitment/recruiters")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is("A")));
	}

	@Test public void listPersonal() throws Exception {
		PersonalDto personal = new PersonalDto(1, "B");
		List<PersonalDto> personalList = Arrays.asList(personal);
		given(recruitmentServiceFacade.listPersonal(anyLong())).willReturn(personalList);

		mvc.perform(get("/recruitment/recruiters/1/personals")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is("B")));
	}

	@Test public void calculateCommission() throws Exception {
		given(recruitmentServiceFacade.calculateCommission(anyLong())).willReturn(1300d);

		mvc.perform(get("/recruitment/recruiters/1/calculate")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.commission", is(1300.0)));
	}

	@Test public void badUrl() throws Exception {
		mvc.perform(get("/recruitment/recruiters/1/calculate1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

}
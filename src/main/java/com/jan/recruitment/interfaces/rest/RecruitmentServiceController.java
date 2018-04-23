package com.jan.recruitment.interfaces.rest;

import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruitment/")
public class RecruitmentServiceController {

	@Autowired
	private RecruitmentServiceFacade recruitmentServiceFacade;



	@RequestMapping(method = RequestMethod.GET,
					value = "/recruiters")
	public List<RecruiterDto> listRecruiters() {
		List<RecruiterDto> recruiterDtoList = recruitmentServiceFacade.listAllRecruiters();
		return recruiterDtoList;
	}

	@RequestMapping(method = RequestMethod.GET,
			value = "/recruiters/{id}/personals")
	public List<PersonalDto> listPersonal(@PathVariable("id") long id) {
		List<PersonalDto> personalDtoList = recruitmentServiceFacade.listPersonal(id);
		return personalDtoList;
	}

	@RequestMapping(method = RequestMethod.GET,
			value = "/recruiters/{id}/calculate")
	public double calculateCommision(@PathVariable("id") long id) {
		return recruitmentServiceFacade.calculateCommission(id);

	}
}



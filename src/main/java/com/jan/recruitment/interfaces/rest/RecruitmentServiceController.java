package com.jan.recruitment.interfaces.rest;

import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
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
			        //produces = "application/com.jan.recruitment-v1+json")
	public List<RecruiterDto> getAllCargo() {
		List<RecruiterDto> recruiterDtoList = recruitmentServiceFacade.listAllRecruiters();
		return recruiterDtoList;
	}
}



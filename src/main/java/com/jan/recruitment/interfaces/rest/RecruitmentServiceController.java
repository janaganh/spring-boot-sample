package com.jan.recruitment.interfaces.rest;

import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<PersonalDto> listPersonal(@PathVariable("id")final long id) {
		List<PersonalDto> personalDtoList = recruitmentServiceFacade.listPersonal(id);
		return personalDtoList;
	}

	@RequestMapping(method = RequestMethod.GET,
			value = "/recruiters/{id}/calculate")
	public Map<String, Object> calculateCommission(@PathVariable("id")final long id) {
		Double commission = recruitmentServiceFacade.calculateCommission(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commission", commission);
		return map;
	}
}



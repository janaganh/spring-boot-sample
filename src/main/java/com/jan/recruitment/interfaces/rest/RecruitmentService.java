package com.jan.recruitment.interfaces.rest;

import com.jan.recruitment.interfaces.facade.RecruitmentServiceFacade;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cargo")
public class RecruitmentService {

	@Inject
	private RecruitmentServiceFacade recruitmentServiceFacade;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RecruiterDto> getAllCargo() {
		List<RecruiterDto> recruiterDtoList = recruitmentServiceFacade.listAllRecruiters();
		return recruiterDtoList;
	}
}



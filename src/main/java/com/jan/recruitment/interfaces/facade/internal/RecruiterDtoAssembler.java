package com.jan.recruitment.interfaces.facade.internal;

import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.interfaces.facade.dto.RecruiterDto;

import java.util.List;
import java.util.stream.Collectors;

public class RecruiterDtoAssembler {
	RecruiterDto toDto(final Recruiter recruiter) {
		return new RecruiterDto(recruiter.getId(), recruiter.getName());
	}

	List<RecruiterDto> toDtoList(final List<Recruiter> recruiterList) {
		return recruiterList.stream().map(this::toDto).collect(Collectors.toList());
	}
}

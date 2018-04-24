package com.jan.recruitment.interfaces.facade.internal;

import com.jan.recruitment.domain.model.Personal;
import com.jan.recruitment.interfaces.facade.dto.PersonalDto;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalDtoAssembler {
	PersonalDto toDto(final Personal personal) {
		return new PersonalDto(personal.getId(), personal.getName());
	}

	List<PersonalDto> toDtoList(final List<Personal> personalList) {
		return personalList.stream().map(this::toDto).collect(Collectors.toList());
	}
}

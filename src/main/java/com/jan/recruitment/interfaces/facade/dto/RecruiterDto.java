package com.jan.recruitment.interfaces.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public class RecruiterDto implements Serializable{
	@Getter
	private long id;
	@Getter
	private String name;
}

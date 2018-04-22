package com.jan.recruitment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jhe on 4/21/2018.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recruiter {


	@Id
	@GeneratedValue
	private Long id;

	private String name;

}

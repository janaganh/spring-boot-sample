package com.jan.recruitment.domain.model;

import java.util.List;

/**
 * Created by jhe on 4/22/2018.
 */
public interface ProfessionRepository {
		List<Profession> findAll();
}

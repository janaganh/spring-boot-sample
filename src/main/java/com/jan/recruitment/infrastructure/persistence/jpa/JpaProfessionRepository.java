package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Profession;
import com.jan.recruitment.domain.model.ProfessionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProfessionRepository extends ProfessionRepository, JpaRepository<Profession, Long> {
}

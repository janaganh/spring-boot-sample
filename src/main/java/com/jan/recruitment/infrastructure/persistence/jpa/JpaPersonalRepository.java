package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Personal;
import com.jan.recruitment.domain.model.PersonalRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonalRepository extends PersonalRepository, JpaRepository<Personal, Long> {

}

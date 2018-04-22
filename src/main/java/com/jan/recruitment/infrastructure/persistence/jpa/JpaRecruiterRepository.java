package com.jan.recruitment.infrastructure.persistence.jpa;


import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruiterRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JpaRecruiterRepository extends JpaRepository<Recruiter, Long> {
	List<Recruiter> findAll();
}

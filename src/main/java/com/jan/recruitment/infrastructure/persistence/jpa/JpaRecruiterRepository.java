package com.jan.recruitment.infrastructure.persistence.jpa;


import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruiterRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jhe on 4/21/2018.
 */
interface JpaRecruiterRepository extends RecruiterRepository, JpaRepository<Recruiter, Long> {

}

package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.domain.model.RecruitmentTransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRecruitmentTransactionRepository extends RecruitmentTransactionRepository, JpaRepository<RecruitmentTransaction, Long> {
}

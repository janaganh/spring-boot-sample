package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Commission;
import com.jan.recruitment.domain.model.CommissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommissionRepository extends CommissionRepository, JpaRepository<Commission, Long> {
}

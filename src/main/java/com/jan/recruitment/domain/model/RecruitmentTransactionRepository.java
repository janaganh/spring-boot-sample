package com.jan.recruitment.domain.model;

import java.util.Date;
import java.util.List;

public interface RecruitmentTransactionRepository {
	List<RecruitmentTransaction> findByRecruiter(long recruiterId, Date fromDate, Date toDate);

	long countByProfession(long transactionId, long professionId);
}


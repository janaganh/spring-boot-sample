package com.jan.recruitment.infrastructure.persistence.jpa;

import com.jan.recruitment.domain.model.Recruiter;
import com.jan.recruitment.domain.model.RecruitmentTransaction;
import com.jan.recruitment.domain.model.RecruitmentTransactionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Transactional(readOnly = true)
public class CustomRecruitmentTransactionRepositoryImpl implements RecruitmentTransactionRepository {

	private static final Logger logger = Logger.getLogger(
			CustomRecruitmentTransactionRepositoryImpl.class.getName());

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<RecruitmentTransaction> findByRecruiter(final long recruiterId, Date fromDate, Date toDate) {
		List<RecruitmentTransaction> recruitmentTransactionList = new ArrayList<>();
		try {
			recruitmentTransactionList = entityManager.createNamedQuery(
					"RecruitmentTransaction.findAllTransactionsByRecruiterForCurrentMonth"
					, RecruitmentTransaction.class)
					.setParameter(1, recruiterId)
					.setParameter(2, fromDate)
					.setParameter(3, toDate)
					.getResultList();
		} catch (NoResultException e) {
			logger.log(Level.INFO, "Unable to get transactions", e);
		}
		return recruitmentTransactionList;
	}

	@Override
	public long countByProfession(long transactionId, long professionId) {
		Long result = 0l;
		try {
			result = entityManager.createNamedQuery("RecruitmentTransaction.countByProfession"
					,Long.class)
					.setParameter(1, transactionId)
					.setParameter(2, professionId)
					.getSingleResult();
		} catch (NoResultException e) {
			logger.log(Level.INFO, "Unable to get transactions", e);
		}
		return result;
	}
}

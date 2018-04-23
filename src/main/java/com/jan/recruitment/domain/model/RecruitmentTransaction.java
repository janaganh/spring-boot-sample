package com.jan.recruitment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQueries({
	@NamedQuery(name = "RecruitmentTransaction.findByRecruiter",
					query = "Select rt from RecruitmentTransaction rt where rt.recruiter.id = :recruiterId "
								+ "and rt.transactionDate between :fromDate and :toDate"),
	@NamedQuery(name = "RecruitmentTransaction.countByProfession",
			query = "Select count(p) from RecruitmentTransaction rt JOIN rt.personals p where rt.id = :transactionId"
					+ " and p.profession.id = :professionId"
	)})
public class RecruitmentTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Recruiter recruiter;

	@Column
	private Date transactionDate;

	@ManyToMany
	@JoinTable(name = "recruitment_transaction_personal",
			joinColumns = { @JoinColumn(name = "recruitment_transaction_id") },
			inverseJoinColumns = { @JoinColumn(name = "personal_id") })
	private Set<Personal> personals = new HashSet();
}

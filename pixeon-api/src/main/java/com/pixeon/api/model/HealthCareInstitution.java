package com.pixeon.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Gerusa
 *
 */
@Entity
public class HealthCareInstitution {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String cnpj;

	/*** saldo */
	private Integer balance;

	@OneToMany(mappedBy="healthCareInstitution")
	private List<Exam> exam;
	
	
	public HealthCareInstitution() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HealthCareInstitution(final String name, final String cnpj) {
		super();
		this.name = name;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(final Integer balance) {
		this.balance = balance;
	}

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(final List<Exam> exam) {
		this.exam = exam;
	}

}

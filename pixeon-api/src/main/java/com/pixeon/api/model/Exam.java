package com.pixeon.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Gerusa
 *
 */
@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String patientName;
	private Integer patientAge;
	private String patientGender;

	private String physicianName;
	private String physicianCRM;
	private String procedureName;

	@ManyToOne
	private HealthCareInstitution healthCareInstitution;

	private Date dhInclusao;
	private Date dhPrimeiroAcesso;
	private Date dhUltimaAlteracao;

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(final Integer patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(final String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(final String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianCRM() {
		return physicianCRM;
	}

	public void setPhysicianCRM(final String physicianCRM) {
		this.physicianCRM = physicianCRM;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(final String procedureName) {
		this.procedureName = procedureName;
	}

	public HealthCareInstitution getHealthCareInstitution() {
		return healthCareInstitution;
	}

	public void setHealthCareInstitution(final HealthCareInstitution healthCareInstitution) {
		this.healthCareInstitution = healthCareInstitution;
	}

	public Date getDhInclusao() {
		return dhInclusao;
	}

	public void setDhInclusao(final Date dhInclusao) {
		this.dhInclusao = dhInclusao;
	}

	public Date getDhPrimeiroAcesso() {
		return dhPrimeiroAcesso;
	}

	public void setDhPrimeiroAcesso(final Date dhPrimeiroAcesso) {
		this.dhPrimeiroAcesso = dhPrimeiroAcesso;
	}

	public Date getDhUltimaAlteracao() {
		return dhUltimaAlteracao;
	}

	public void setDhUltimaAlteracao(final Date dhUltimaAlteracao) {
		this.dhUltimaAlteracao = dhUltimaAlteracao;
	}

}

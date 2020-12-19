package com.pixeon.api.resource.dto;

import com.pixeon.api.model.Exam;
import com.pixeon.api.util.StringUtil;

/**
 * <p>
 * Classe responsável por representar o retorno da solicitação de consulta/
 * detalhamento a um Exam.
 * </p>
 * 
 * @author Gerusa
 *
 */
public class ExamDto {

	private Long id;
	private String cnpjInstituicao;

	private String patientName;
	private Integer patientAge;
	private String patientGender;

	private String physicianName;
	private String physicianCRM;
	private String procedureName;

	private String dhInclusao;
	private String dhPrimeiroAcesso;
	private String dhUltimaAlteracao;

	public ExamDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamDto(final Exam exam) {
		this.id = exam.getId();
		this.cnpjInstituicao = exam.getHealthCareInstitution().getCnpj();
		
		this.patientName = exam.getPatientName();
		this.patientAge = exam.getPatientAge();
		this.patientGender = exam.getPatientGender();
		
		this.physicianName = exam.getPhysicianName();
		this.physicianCRM = exam.getPhysicianCRM();
		this.procedureName = exam.getProcedureName();
		
		this.dhInclusao = StringUtil.converterDateEmString(exam.getDhInclusao());
		this.dhPrimeiroAcesso = StringUtil.converterDateEmString(exam.getDhPrimeiroAcesso());
		this.dhUltimaAlteracao = StringUtil.converterDateEmString(exam.getDhUltimaAlteracao());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCnpjInstituicao() {
		return cnpjInstituicao;
	}

	public void setCnpjInstituicao(final String cnpjInstituicao) {
		this.cnpjInstituicao = cnpjInstituicao;
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

	public String getDhInclusao() {
		return dhInclusao;
	}

	public void setDhInclusao(final String dhInclusao) {
		this.dhInclusao = dhInclusao;
	}
	
	public final String getDhPrimeiroAcesso() {
		return dhPrimeiroAcesso;
	}

	public final void setDhPrimeiroAcesso(final String dhPrimeiroAcesso) {
		this.dhPrimeiroAcesso = dhPrimeiroAcesso;
	}

	public String getDhUltimaAlteracao() {
		return dhUltimaAlteracao;
	}

	public void setDhUltimaAlteracao(final String dhUltimaAlteracao) {
		this.dhUltimaAlteracao = dhUltimaAlteracao;
	}

}

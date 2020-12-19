package com.pixeon.api.resource.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.pixeon.api.model.Exam;
import com.pixeon.api.model.HealthCareInstitution;
import com.pixeon.api.util.StringUtil;

/**
 * <p>
 * Classe responsável por representar um formulário utilizado no cadastro da
 * entidade Exam.
 * </p>
 * 
 * @author Gerusa
 *
 */
public class ExamForm {

	@NotNull
	@NotEmpty
	@Length(min = 14, max = 18)
	private String cnpjInstituition;
	
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 100)
	private String patientName;
	
	@NotNull
	private Integer patientAge;
	
	@NotNull
	@NotEmpty
	private String patientGender;

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 100)
	private String physicianName;
	
	@NotNull
	@NotEmpty
	@Length(min = 1, max = 20)
	private String physicianCRM;
	
	@NotNull
	@NotEmpty
	private String procedureName;
	
	public ExamForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCnpjInstituition() {
		return cnpjInstituition;
	}

	public void setCnpjInstituition(final String cnpjInstituition) {
		this.cnpjInstituition = cnpjInstituition;
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

	public Exam criarExam(final HealthCareInstitution healthCareInstitution) {
		final Exam exam = new Exam();
		exam.setDhInclusao(new Date());
		
		exam.setPatientName(StringUtil.getMaiusculoSemEspaco(this.getPatientName()));
		exam.setPatientAge(this.getPatientAge());
		exam.setPatientGender(StringUtil.getMaiusculoSemEspaco(this.getPatientGender()));
		
		exam.setPhysicianName(StringUtil.getMaiusculoSemEspaco(this.getPhysicianName()));
		exam.setPhysicianCRM(StringUtil.getMaiusculoSemEspaco(this.getPhysicianCRM()));
		exam.setProcedureName(StringUtil.getMaiusculoSemEspaco(this.getProcedureName()));
		
		exam.setHealthCareInstitution(healthCareInstitution);
		
		return exam;
	}

}

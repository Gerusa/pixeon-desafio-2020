package com.pixeon.api.resource.form;

import java.util.Date;

import com.pixeon.api.model.Exam;
import com.pixeon.api.util.StringUtil;

/**
 * <p>
 * Classe responsável por representar um formulário utilizado na atualização da
 * entidade Exam.
 * </p>
 * 
 * @author Gerusa
 *
 */
public class ExamFormAtualizacao {
	
	private String patientName;
	private Integer patientAge;
	private String patientGender;

	private String physicianName;
	private String physicianCRM;
	private String procedureName;
	
	public ExamFormAtualizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final String getPatientName() {
		return patientName;
	}

	public final void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public final Integer getPatientAge() {
		return patientAge;
	}

	public final void setPatientAge(final Integer patientAge) {
		this.patientAge = patientAge;
	}

	public final String getPatientGender() {
		return patientGender;
	}

	public final void setPatientGender(final String patientGender) {
		this.patientGender = patientGender;
	}

	public final String getPhysicianName() {
		return physicianName;
	}

	public final void setPhysicianName(final String physicianName) {
		this.physicianName = physicianName;
	}

	public final String getPhysicianCRM() {
		return physicianCRM;
	}

	public final void setPhysicianCRM(final String physicianCRM) {
		this.physicianCRM = physicianCRM;
	}

	public final String getProcedureName() {
		return procedureName;
	}

	public final void setProcedureName(final String procedureName) {
		this.procedureName = procedureName;
	}

	public void atualizarExam(final Exam exam) {
		exam.setDhUltimaAlteracao(new Date());
		
		exam.setPatientName(this.getString(exam.getPatientName(), this.getPatientName()));
		exam.setPatientAge(this.getInteger(exam.getPatientAge(), this.getPatientAge()));
		exam.setPatientGender(this.getString(exam.getPatientGender(), this.getPatientGender()));
		
		exam.setPhysicianName(this.getString(exam.getPhysicianName(), this.getPhysicianName()));
		exam.setPhysicianCRM(this.getString(exam.getPhysicianCRM(), this.getPhysicianCRM()));
		exam.setProcedureName(this.getString(exam.getProcedureName(), this.getProcedureName()));
	}
	
	private String getString(final String valorAtual, final String valorRecebido) {
		return valorRecebido != null && !valorRecebido.equals("") ? StringUtil.getMaiusculoSemEspaco(valorRecebido) : valorAtual;
	}
	
	private Integer getInteger(final Integer valorAtual, final Integer valorRecebido) {
		return valorRecebido != null ? valorRecebido : valorAtual;
	}

}

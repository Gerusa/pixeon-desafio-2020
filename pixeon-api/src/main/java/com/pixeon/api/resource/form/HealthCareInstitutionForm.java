package com.pixeon.api.resource.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.pixeon.api.model.HealthCareInstitution;
import com.pixeon.api.util.StringUtil;

/**
 * <p>
 * Classe responsável por representar o formulário utilizado no cadastro da
 * entidade HealthCareInstitution.
 * </p>
 * 
 * @author Gerusa
 *
 */
public class HealthCareInstitutionForm {
	
	@NotNull
	@NotEmpty
	@Length(min = 1, max = 250)
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 14, max = 18)
	private String cnpj;

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
	
	public HealthCareInstitution criarHealthCareInstitution() {
		return new HealthCareInstitution(StringUtil.getMaiusculoSemEspaco(this.getName()), StringUtil.getSomenteNumeros(this.getCnpj()));
	}
	
}

package com.pixeon.api.config.validation;

/**
 * Representa a validação em algum campo de algum formulário.
 * 
 * @author Gerusa
 *
 */
public class ValidacaoFormularioDto {

	private String campo;
	private String validacao;
	
	public ValidacaoFormularioDto(final String campo, final String validacao) {
		super();
		this.campo = campo;
		this.validacao = validacao;
	}

	public String getCampo() {
		return campo;
	}

	public String getValidacao() {
		return validacao;
	}
	
}

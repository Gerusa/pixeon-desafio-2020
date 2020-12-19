package com.pixeon.api.util;

/**
 * Classe utilitária para validações em geral.
 * 
 * @author Gerusa
 *
 */
public class ValidationUtil {
	

	/**
	 * Validação superficial do cnpj.
	 * @param valor
	 */
	public static void validarCampoCnpj(final String cnpjParam) {
		final String cnpj = StringUtil.getSomenteNumeros(cnpjParam);
		
		if(cnpj == null || cnpj.length() != 14) {
			throw new IllegalArgumentException("Campo inválido: cnpj");
		}
	}
	
	/**
	 * @param name
	 */
	public static void validarCampoName(final String name) {
		if(name == null || name.trim().equals("")){
			throw new IllegalArgumentException("Campo inválido: name");
		}
	}

}

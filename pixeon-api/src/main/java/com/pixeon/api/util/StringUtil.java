package com.pixeon.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe utilitária para o tipo String.
 * 
 * @author Gerusa
 *
 */
public class StringUtil {
	
	 /**
     * <p>
     * Método responsável por retornar somente os números do valor informado.
     * <p>
     *
     * @param valor
     * @return
     */
    public static String getSomenteNumeros(final String valor) {
        return valor != null ? valor.replaceAll("[^0-9]", "").trim() : valor;
    }
    
    /**
     * @param valor
     * @return
     */
    public static String getMaiusculoSemEspaco(final String valor) {
    	return valor != null ? valor.trim().toUpperCase() : valor;
    }
    
    /**
     * @param data
     * @return
     */
    public static String converterDateEmString(final Date data) {
		return data != null ? new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(data) : "";
	}

}

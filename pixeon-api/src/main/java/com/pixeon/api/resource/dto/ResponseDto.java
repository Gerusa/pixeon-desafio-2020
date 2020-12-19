package com.pixeon.api.resource.dto;

/**
 * <p>
 * Classe responsável por representar o retorno de um recurso.
 * </p>
 * 
 * @author Gerusa
 *
 */
public class ResponseDto {
	
	public static final String OPERACAO_REALIZADA_COM_SUCESSO = "Operação realizada com sucesso";
	public static final String OPERACAO_NAO_REALIZADA = "Operação não realizada";
	
	private String mensagem;
	private String detalhe;

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ResponseDto( final String mensagem, final String detalhe) {
		super();
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(final String mensagem) {
		this.mensagem = mensagem;
	}


	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(final String detalhe) {
		this.detalhe = detalhe;
	}
	
}

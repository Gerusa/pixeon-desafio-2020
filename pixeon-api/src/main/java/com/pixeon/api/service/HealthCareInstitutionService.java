package com.pixeon.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pixeon.api.model.HealthCareInstitution;
import com.pixeon.api.repository.HealthCareInstitutionRepository;
import com.pixeon.api.resource.dto.ResponseDto;
import com.pixeon.api.resource.form.HealthCareInstitutionForm;
import com.pixeon.api.util.StringUtil;
import com.pixeon.api.util.ValidationUtil;

/**
 * <p>
 * Classe responsável por 
 * </p>
 * 
 * @author Gerusa
 *
 */
@Service
public class HealthCareInstitutionService {

	private static final int VINTE = 20;
	
	@Autowired
	private HealthCareInstitutionRepository repository;
	

	/**
	 * <p>
	 * Cada nova instituição de saúde deve receber 20 moedas pixeon para salvar
	 * os exames e recuperá-los.
	 * </p>
	 * 
	 * @param form
	 * @return
	 */
	public ResponseEntity<ResponseDto> cadastrar(final HealthCareInstitutionForm form) {
		
		this.validarDados(form);
		
		final HealthCareInstitution health = this.criarHealthCareInstitution(form);
		
		final String msg = "Instituição "  + health.getName() + " - " + health.getCnpj() + " cadastrada.";
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ResponseDto.OPERACAO_REALIZADA_COM_SUCESSO, msg));
	}

	private void validarDados(final HealthCareInstitutionForm form) {
		
		final String name = form.getName();
		
		ValidationUtil.validarCampoName(name);
		
		final String cnpjParam = form.getCnpj();
		
		ValidationUtil.validarCampoCnpj(cnpjParam);
		
		this.validarSeInstituicaoJaExiste(name, cnpjParam, true);
	}

	private void validarSeInstituicaoJaExiste(final String nameParam, final String cnpjParam, final boolean isCadastro) {
		
		final HealthCareInstitution health = this.consultarPorCnpj(cnpjParam, isCadastro);

		if(health != null) {
			
			String msgValidacao = null;
			
			if(health.getName().equalsIgnoreCase(nameParam.trim())){
				msgValidacao = "Instituição já cadastrada para os parâmetros informados: " + nameParam + " - " + cnpjParam;
				
			} else {
				msgValidacao = "Instituição " + health.getName() + " já cadastrada para o cnpj informado: " + cnpjParam;
			}
			
			throw new IllegalArgumentException(msgValidacao);
		}
	}
	
	private HealthCareInstitution criarHealthCareInstitution(final HealthCareInstitutionForm form) {
		final HealthCareInstitution health = form.criarHealthCareInstitution();
		health.setBalance(HealthCareInstitutionService.VINTE);
		
		return this.repository.save(health);
	}
	
	/**
	 * @param cnpjParam
	 * @param isCadastro
	 * - true indica que é cadastro de HealthCareInstitution
	 * @return
	 */
	public HealthCareInstitution consultarPorCnpj(final String cnpjParam, final boolean isCadastro) {
		HealthCareInstitution health = null;
		
		if(cnpjParam != null && !cnpjParam.equals("")) {
			
			health = this.repository.findByCnpj(StringUtil.getSomenteNumeros(cnpjParam));
		}
		
		if(!isCadastro && health == null){
			throw new IllegalArgumentException("Não existe Instituição para o cnpj informado: " + cnpjParam);
		}
		
		return health;
	}

	/**
	 * @param health
	 */
	public void subtrairUmDoOrcamento(final HealthCareInstitution health) {
		health.setBalance(health.getBalance() - 1);
		this.repository.save(health);
		
	}
	
	/**
	 * @param health
	 */
	public void validarSeInstituicaoPossuiOrcamento(final HealthCareInstitution health) {
		if(health.getBalance().compareTo(0) == 0){
			throw new IllegalArgumentException("Instituição sem orçamento: " + health.getCnpj());
		}
		
	}
}

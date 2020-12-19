package com.pixeon.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.api.resource.dto.ResponseDto;
import com.pixeon.api.resource.form.HealthCareInstitutionForm;
import com.pixeon.api.service.HealthCareInstitutionService;

/**
 * <p>
 * Classe responsável por prover recursos referentes a instituições de saúde
 * (HealthCareInstitution).
 * </p>
 * 
 * @author Gerusa
 *
 */
@RestController
@RequestMapping("/healthCare")
public class HealthCareInstitutionResource {
	
	@Autowired
	private HealthCareInstitutionService service;
	
	/**
	 * @param form
	 * @return
	 * 201: criado com sucesso.
	 * 400: parâmetros inválidos.
	 * 
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<ResponseDto> cadastrar(@RequestBody @Valid final HealthCareInstitutionForm form) {
		try {
			
			return this.service.cadastrar(form);
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.badRequest().body(new ResponseDto(ResponseDto.OPERACAO_NAO_REALIZADA, e.getMessage()));
		}
	}

}

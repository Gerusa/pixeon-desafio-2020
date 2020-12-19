package com.pixeon.api.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pixeon.api.resource.dto.ResponseDto;
import com.pixeon.api.resource.form.ExamFormAtualizacao;
import com.pixeon.api.resource.form.ExamForm;
import com.pixeon.api.service.ExamService;
import com.pixeon.api.util.StringUtil;

/**
 * <p>
 * Classe responsável por prover recursos referentes a exames.
 * </p>
 * 
 * @author Gerusa
 *
 */
@RestController
@RequestMapping("/exam")
public class ExamResource {
	
	@Autowired
	private ExamService service;
	
	/**
	 * @param form
	 * @param uriBuilder
	 * @return
	 * 201: criado com sucesso.
	 * 400: parâmetros inválidos.
	 * 
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<ResponseDto> cadastrar(@RequestBody @Valid final ExamForm form, final UriComponentsBuilder uriBuilder) {
		
		try {
			
			final Long idExam = this.service.cadastrar(form);
			
			final String cnpjInstituicao = StringUtil.getSomenteNumeros(form.getCnpjInstituition());
			
			final URI location = uriBuilder.path("/exam/{cnpjInstituicao}/{id}").buildAndExpand(cnpjInstituicao, idExam).toUri();
			
			final String msg = "Exame " + form.getProcedureName() + " cadastrado para a instituição " + cnpjInstituicao;
			
			return ResponseEntity.created(location).body(new ResponseDto(ResponseDto.OPERACAO_REALIZADA_COM_SUCESSO, msg));
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.badRequest().body(new ResponseDto(ResponseDto.OPERACAO_NAO_REALIZADA, e.getMessage()));
		}
		
	}
	
	/**
	 * @param cnpjInstituicao
	 * @param idExam
	 * @param form
	 * @return
	 * 200: atualizado com sucesso
	 * 400: parâmetros inválidos
	 * 
	 */
	@PutMapping("/{cnpjInstituicao}/{id}")
	@Transactional
	public  ResponseEntity<ResponseDto> atualizar(@PathVariable("cnpjInstituicao") final String cnpjInstituicao, @PathVariable("id") final Long idExam, @RequestBody @Valid final ExamFormAtualizacao form) {
		try {
			
			return this.service.atualizar(cnpjInstituicao, idExam, form);
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.badRequest().body(new ResponseDto(ResponseDto.OPERACAO_NAO_REALIZADA, e.getMessage()));
		}
	}
	
	/**
	 * @param cnpjInstituicao
	 * @param idExam
	 * @return 
	 * 200: retornado com sucesso 
	 * 400: parâmetros inválidos
	 */
	@GetMapping("/{cnpjInstituicao}/{id}")
	public ResponseEntity<?> detalhar(@PathVariable("cnpjInstituicao") final String cnpjInstituicao, @PathVariable("id") final Long idExam) {
		
		try {
			
			return this.service.detalhar(cnpjInstituicao, idExam);
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.badRequest().body(new ResponseDto(ResponseDto.OPERACAO_NAO_REALIZADA, e.getMessage()));
		}
	}
	
	/**
	 * @param cnpjInstituicao
	 * @param idExam
	 * @return
	 * 200: removido com sucesso
	 * 400: parâmetros inválidos
	 * 
	 */
	@DeleteMapping("/{cnpjInstituicao}/{id}")
	@Transactional
	public  ResponseEntity<ResponseDto> remover(@PathVariable("cnpjInstituicao") final String cnpjInstituicao, @PathVariable("id") final Long idExam) {
		try {
			
			return this.service.remover(cnpjInstituicao, idExam);
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.badRequest().body(new ResponseDto(ResponseDto.OPERACAO_NAO_REALIZADA, e.getMessage()));
		}
	}
	
}

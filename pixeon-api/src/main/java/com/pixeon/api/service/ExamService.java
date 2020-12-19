package com.pixeon.api.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pixeon.api.model.Exam;
import com.pixeon.api.model.HealthCareInstitution;
import com.pixeon.api.repository.ExamRepository;
import com.pixeon.api.resource.dto.ExamDto;
import com.pixeon.api.resource.dto.ResponseDto;
import com.pixeon.api.resource.form.ExamFormAtualizacao;
import com.pixeon.api.resource.form.ExamForm;
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
public class ExamService {
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private HealthCareInstitutionService healthService;

	/**
	 * <p>
	 * Cada exame criado com sucesso deve cobrar 1 moeda pixeon da instituição
	 * de saúde.
	 * </p>
	 * 
	 * @param form
	 * @return
	 */
	public Long cadastrar(final ExamForm form) {
		
		final String cnpj = form.getCnpjInstituition();
		
		ValidationUtil.validarCampoCnpj(cnpj);
		
		final HealthCareInstitution health = this.healthService.consultarPorCnpj(cnpj, false);
		
		this.healthService.validarSeInstituicaoPossuiOrcamento(health);
		
		final Long idExam = this.criarExam(form, health);
		
		this.healthService.subtrairUmDoOrcamento(health);
		
		return idExam;
	}

	private Long criarExam(final ExamForm form, final HealthCareInstitution health) {
		final Exam exam = form.criarExam(health);
		
		this.examRepository.save(exam);
		
		return exam.getId();
	}

	/**
	 * <p>
	 * Uma instituição de saúde não deve ter acesso a um exame que pertença a
	 * outra instituição de saúde.
	 * </p>
	 * 
	 * @param cnpjInstituicao
	 * @param idExam
	 * @param form
	 * @return
	 */
	public ResponseEntity<ResponseDto> atualizar(final String cnpjInstituicao, final Long idExam, final ExamFormAtualizacao form) {
		
		ValidationUtil.validarCampoCnpj(cnpjInstituicao);
		
		final Exam exam = this.consultarPorId(idExam);
		
		this.validarSeExamePertenceAInstituicao(cnpjInstituicao, exam);
		
		this.atualizarExam(form, exam);

		final String msg = "Exame "  + idExam + " atualizado.";
		
		return ResponseEntity.ok().body(new ResponseDto(ResponseDto.OPERACAO_REALIZADA_COM_SUCESSO, msg));
	}

	private Exam consultarPorId(final Long id) {
		final Optional<Exam> optional = this.examRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new IllegalArgumentException("Não existe exame cadastrado para o id informado: " + id);
		}
		
		return optional.get();
	}
	
	private void validarSeExamePertenceAInstituicao(final String cnpjInstituicao, final Exam exam) {
		if(!StringUtil.getSomenteNumeros(cnpjInstituicao).equals(exam.getHealthCareInstitution().getCnpj())){
			throw new IllegalArgumentException("Exame " + exam.getId() + " não pertence à instituição " + cnpjInstituicao);
		}
	}
	
	private void atualizarExam(final ExamFormAtualizacao form, final Exam exam) {
		form.atualizarExam(exam);
		
		this.examRepository.save(exam);
	}
	
	
	/**
	 * <p>
	 * 1 - Uma instituição de saúde não deve ter acesso a um exame que pertença a
	 * outra instituição de saúde; 
	 * 
	 * 2 - Deve-se cobrar 1 moeda pixeon do orçamento
	 * quando uma instituição de saúde recuperar um exame, mas se a instituição
	 * recuperar o mesmo exame mais de uma vez você não deve cobrar, o que
	 * significa que terá que cobrar apenas o primeiro acesso ao exame.
	 * </p>
	 * 
	 * @param cnpjInstituicao
	 * @param idExam
	 * @return
	 */
	public ResponseEntity<ExamDto> detalhar(final String cnpjInstituicao, final Long idExam) {
		
		ValidationUtil.validarCampoCnpj(cnpjInstituicao);

		final Exam exam = this.consultarPorId(idExam);
		
		this.validarSeExamePertenceAInstituicao(cnpjInstituicao, exam);
		
		if(exam.getDhPrimeiroAcesso() == null){
			
			final HealthCareInstitution health = exam.getHealthCareInstitution();
			this.healthService.validarSeInstituicaoPossuiOrcamento(health);
			
			exam.setDhPrimeiroAcesso(new Date());
			this.examRepository.save(exam);
			
			this.healthService.subtrairUmDoOrcamento(health);
		}
		
		return ResponseEntity.ok().body(new ExamDto(exam)); 
	}

	/**
	 * <p>
	 * Uma instituição de saúde não deve ter acesso a um exame que pertença a
	 * outra instituição de saúde.
	 * </p>
	 * 
	 * @param cnpjInstituicao
	 * @param idExam
	 * @return
	 */
	public ResponseEntity<ResponseDto> remover(final String cnpjInstituicao, final Long idExam) {
		
		ValidationUtil.validarCampoCnpj(cnpjInstituicao);

		final Exam exam = this.consultarPorId(idExam);
		
		this.validarSeExamePertenceAInstituicao(cnpjInstituicao, exam);
		
		this.examRepository.deleteById(idExam);
		
		final String msg = "Exame "  + idExam + " removido.";
		
		return ResponseEntity.ok().body(new ResponseDto(ResponseDto.OPERACAO_REALIZADA_COM_SUCESSO, msg)); 
	}
	
}

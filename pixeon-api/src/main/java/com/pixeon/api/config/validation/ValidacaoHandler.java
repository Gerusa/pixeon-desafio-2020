package com.pixeon.api.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Esta classe é um interceptador para ser acionada sempre que ocorrer alguma
 * exceção em algum resource, durante a validação (@Valid) em alguma classe que
 * esteja usando as anotações do bean validation - ex:
 * HealthCareInstitutionForm.
 * 
 * @author Gerusa
 *
 */
@RestControllerAdvice
public class ValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	/**
	 * Indica ao spring que, caso ocorra uma exceção, este método deve ser
	 * acionado. A classe em parênteses é o tipo de exceção que pode ocorrer no
	 * controller.
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidacaoFormularioDto> handle(MethodArgumentNotValidException exception) {

		final List<ValidacaoFormularioDto> dto = new ArrayList<>();

		final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(fe -> dto.add(new ValidacaoFormularioDto(fe.getField(), this.messageSource.getMessage(fe, LocaleContextHolder.getLocale()))));
		
		return dto;

	}

}

package com.pedido.domain.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pedido.domain.model.ErroModel;

@ControllerAdvice
public class HttpDomainErroException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessNotFoundException.class)
	public ResponseEntity<?> businessNotFound(BusinessNotFoundException e) {
		ErroModel erroModel = erroResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),
				e.getMessage(), OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroModel);
	}

	@ExceptionHandler(BusinessBadRequestException.class)
	public ResponseEntity<?> businessBadRequest(BusinessBadRequestException e) {
		ErroModel erroModel = erroResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(),
				e.getMessage(), OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroModel);
	}
	
	private ErroModel erroResponse(Integer erroCode, String detalhe, String mensagem, OffsetDateTime timestamp) {
		return ErroModel.builder().erroCode(erroCode).details(detalhe).mensagem(mensagem).timestamp(timestamp)
				.build();
	}
}
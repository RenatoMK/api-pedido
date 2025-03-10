package com.pedido.data.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pedido.domain.exception.BusinessBadRequestException;
import com.pedido.domain.model.ErroModel;

@ControllerAdvice
public class HttpDataErroException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessInternalServerErrorException.class)
	public ResponseEntity<?> businessInternalServer(BusinessBadRequestException e) {
		ErroModel erroModel = erroResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				"Erro interno", OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroModel);
	}
	
	
	private ErroModel erroResponse(Integer erroCode, String detalhe, String mensagem, OffsetDateTime timestamp) {
		return ErroModel.builder().erroCode(erroCode).details(detalhe).mensagem(mensagem).timestamp(timestamp)
				.build();
	}
}
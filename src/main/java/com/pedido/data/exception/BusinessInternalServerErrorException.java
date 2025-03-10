package com.pedido.data.exception;

public class BusinessInternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 8849787625182024926L;
	
	public BusinessInternalServerErrorException(String mensagem) {
		super(mensagem);
	}

}

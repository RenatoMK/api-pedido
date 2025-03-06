package com.pedido.domain.model;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErroModel {
	private Integer erroCode;
	private String mensagem;
	private String details;
	private OffsetDateTime timestamp;
}

package com.pedido.api.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecuperarPedidoResponseDTO extends PedidoDTO{
	
	private Long id;
	private BigDecimal imposto;
	private String status;

}

package com.pedido.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecuperarPedidoListResponseDTO {
	
	private List<RecuperarPedidoResponseDTO> pedidos;

}

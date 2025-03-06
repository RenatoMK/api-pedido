package com.pedido.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemRequestDTO {
	
    private Long produtoId;
    private Long quantidade;
    private Double valor;

}

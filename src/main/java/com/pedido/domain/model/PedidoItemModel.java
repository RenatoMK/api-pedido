package com.pedido.domain.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemModel {
	
    private Long produtoId;
    private Long quantidade;
    private BigDecimal valor;

}

package com.pedido.domain.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel {
	
    private Long pedidoId;
    private Long clienteId;
    private String status;
    private Long id;
    private BigDecimal imposto;
    private List<PedidoItemModel> itens;
}

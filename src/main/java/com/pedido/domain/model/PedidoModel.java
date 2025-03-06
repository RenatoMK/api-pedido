package com.pedido.domain.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel {
	
    private Long pedidoId;
    private Long clienteId;
    private List<PedidoItemModel> itens;
}

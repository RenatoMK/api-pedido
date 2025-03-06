package com.pedido.domain.model;

import java.util.List;

import com.pedido.api.dto.PedidoItemRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel {
	
    private Long pedidoId;
    private Long clienteId;
    private List<PedidoItemRequestDTO> itens;
}

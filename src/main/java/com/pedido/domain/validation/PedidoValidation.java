package com.pedido.domain.validation;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;

public interface PedidoValidation {

	void validaPedido(CriarPedidoItemRequestDTO criarPedidoItemRequestDTO);
	
}

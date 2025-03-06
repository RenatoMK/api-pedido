package com.pedido.domain.validation;

import com.pedido.api.dto.PedidoRequestDTO;

public interface PedidoValidation {

	void validaPedido(PedidoRequestDTO pedidoRequestDTO);
	
}

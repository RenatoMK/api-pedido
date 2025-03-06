package com.pedido.domain.validation;

import com.pedido.api.dto.PedidoRequestDTO;

public interface RequestValidation {
	
	void validaRequest(PedidoRequestDTO pedidoRequestDTO);

}

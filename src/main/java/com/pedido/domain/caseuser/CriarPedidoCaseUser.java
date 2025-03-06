package com.pedido.domain.caseuser;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.api.dto.PedidoResponseDTO;

public interface CriarPedidoCaseUser {

	PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO);
	
}

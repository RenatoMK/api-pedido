package com.pedido.domain.caseuser;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;

public interface CriarPedidoCaseUser {

	CriarPedidoResponseDTO criarPedido(CriarPedidoItemRequestDTO criarPedidoItemRequestDTO);
	
}

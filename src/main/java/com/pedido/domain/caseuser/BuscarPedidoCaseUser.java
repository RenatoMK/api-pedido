package com.pedido.domain.caseuser;

import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;

public interface BuscarPedidoCaseUser {

	RecuperarPedidoResponseDTO buscarPedidoPorId(Long id);
	
	RecuperarPedidoListResponseDTO buscarPedidoPorStatus(String status); 
	
}

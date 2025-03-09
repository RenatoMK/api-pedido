package com.pedido.data.service;

import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;

public interface BuscarPedidoService {

	PedidoModel buscarPedidoPorId(Long id);
	
	PedidoListModel buscarPedidoPorStatus(String status); 
	
	
}

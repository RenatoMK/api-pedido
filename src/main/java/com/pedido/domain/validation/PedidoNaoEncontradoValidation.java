package com.pedido.domain.validation;

import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;

public interface PedidoNaoEncontradoValidation {
	
	void pedidoNaoEncontrado(PedidoModel pedidoModel);
	
	void pedidoNaoEncontrado(PedidoListModel pedidoListModel );
	
}

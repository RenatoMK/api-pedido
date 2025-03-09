package com.pedido.domain.validation.impl;

import org.springframework.stereotype.Service;

import com.pedido.domain.exception.BusinessNotFoundException;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.validation.PedidoNaoEncontradoValidation;

@Service
public class PedidoNaoEncontradoValidationImpl implements PedidoNaoEncontradoValidation{

	@Override
	public void pedidoNaoEncontrado(PedidoModel pedidoModel) {
		if(pedidoModel == null) {
			throw new BusinessNotFoundException("Pedido não encontrado");
		}
	}

	@Override
	public void pedidoNaoEncontrado(PedidoListModel pedidoListModel ) {
		if(pedidoListModel.getPedidos().isEmpty()) {
			throw new BusinessNotFoundException("Pedido não encontrado");
		}
	}
}

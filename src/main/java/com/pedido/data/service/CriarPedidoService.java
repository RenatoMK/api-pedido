package com.pedido.data.service;

import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.domain.model.PedidoModel;

public interface CriarPedidoService {

	PedidoModel criarPedido(PedidoModel pedidoModel);
}

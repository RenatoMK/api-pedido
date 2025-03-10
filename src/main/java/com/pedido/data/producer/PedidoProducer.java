package com.pedido.data.producer;

import com.pedido.domain.model.PedidoModel;

public interface PedidoProducer {

	void enviarMensagem(PedidoModel pedidoModel);

}

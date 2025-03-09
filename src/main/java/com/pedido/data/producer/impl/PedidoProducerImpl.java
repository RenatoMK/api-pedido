package com.pedido.data.producer.impl;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedido.data.exception.BusinessInternalServerErrorException;
import com.pedido.data.producer.PedidoProducer;
import com.pedido.domain.model.PedidoModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoProducerImpl implements PedidoProducer {
	
	private final QueueChannel filaVirtual;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	public void enviarMensagem(PedidoModel pedidoModel) {

		try {
			
			String jsonPedido = objectMapper.writeValueAsString(pedidoModel);
			
			filaVirtual.send(new GenericMessage<>(jsonPedido));
			
			log.info("Enviado o pedido " + jsonPedido);
		
		} catch (Exception e) {
			
			throw new BusinessInternalServerErrorException("Erro interno");
		
		}
	}

}

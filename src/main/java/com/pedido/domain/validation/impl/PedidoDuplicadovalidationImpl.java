package com.pedido.domain.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.domain.exception.BusinessBadRequestException;
import com.pedido.domain.validation.PedidoValidation;

@Configuration
public class PedidoDuplicadovalidationImpl  implements PedidoValidation {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void validaPedido(PedidoRequestDTO pedidoRequestDTO) {
		// TODO Auto-generated method stub
		if(pedidoRepository.findByPedidoId(pedidoRequestDTO.getPedidoId()) != null) {
			throw new BusinessBadRequestException("Pedido já cadastrado.");
		}
		System.err.println("teste");
		
	}

}

package com.pedido.domain.validation.impl;

import org.springframework.context.annotation.Configuration;

import com.pedido.api.dto.PedidoItemRequestDTO;
import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.domain.exception.BusinessBadRequestException;
import com.pedido.domain.validation.RequestValidation;

@Configuration
public class CamposValidationImpl implements RequestValidation {

	@Override
	public void validaRequest(PedidoRequestDTO pedidoRequestDTO) {
		if(pedidoRequestDTO.getClienteId() == null) {
			throw new BusinessBadRequestException("ClienteId não pode ser null");
		}
		if(pedidoRequestDTO.getPedidoId() == null) {
			throw new BusinessBadRequestException("PedidoId não pode ser null");
		}
		if(pedidoRequestDTO.getItens() == null || pedidoRequestDTO.getItens().isEmpty()) {
			throw new BusinessBadRequestException("Itens não pode ser null/vazio");
		}
		
		for(PedidoItemRequestDTO pedidoItemRequestDTO : pedidoRequestDTO.getItens()) {
			if(pedidoItemRequestDTO.getProdutoId() == null) {
				throw new BusinessBadRequestException("ProdutoId não pode ser null");
			}
			if(pedidoItemRequestDTO.getQuantidade() == null) {
				throw new BusinessBadRequestException("Quantidade não pode ser null");
			}
			if(pedidoItemRequestDTO.getValor() == null) {
				throw new BusinessBadRequestException("Valor não pode ser null");
			}
		}
	}

}

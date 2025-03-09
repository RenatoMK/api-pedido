package com.pedido.domain.validation.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.dto.PedidoItemDTO;
import com.pedido.domain.exception.BusinessBadRequestException;
import com.pedido.domain.validation.PedidoValidation;

@Configuration
@Primary
public class CamposValidationImpl implements PedidoValidation {

	@Override
	public void validaPedido(CriarPedidoItemRequestDTO criarPedidoItemRequestDTO) {
		if(criarPedidoItemRequestDTO.getClienteId() == null) {
			throw new BusinessBadRequestException("ClienteId não pode ser null");
		}
		if(criarPedidoItemRequestDTO.getPedidoId() == null) {
			throw new BusinessBadRequestException("PedidoId não pode ser null");
		}
		if(criarPedidoItemRequestDTO.getItens() == null || criarPedidoItemRequestDTO.getItens().isEmpty()) {
			throw new BusinessBadRequestException("Itens não pode ser null/vazio");
		}
		
		for(PedidoItemDTO pedidoItemDTO : criarPedidoItemRequestDTO.getItens()) {
			if(pedidoItemDTO.getProdutoId() == null) {
				throw new BusinessBadRequestException("ProdutoId não pode ser null");
			}
			if(pedidoItemDTO.getQuantidade() == null) {
				throw new BusinessBadRequestException("Quantidade não pode ser null");
			}
			if(pedidoItemDTO.getValor() == null) {
				throw new BusinessBadRequestException("Valor não pode ser null");
			}
		}
	}

}

package com.pedido.domain.caseuser.impl;

import org.springframework.stereotype.Service;

import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;
import com.pedido.data.service.BuscarPedidoService;
import com.pedido.domain.caseuser.BuscarPedidoCaseUser;
import com.pedido.domain.mapper.PedidoDomainMapper;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.validation.PedidoNaoEncontradoValidation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuscarPedidoCaseUserImpl implements BuscarPedidoCaseUser{

	private final BuscarPedidoService buscarPedidoService;
	
	private final PedidoDomainMapper pedidoMapper;
	
	private final PedidoNaoEncontradoValidation pedidoNaoEncontradoValidation;
	
	@Override
	public RecuperarPedidoResponseDTO buscarPedidoPorId(Long id) {
		
		PedidoModel pedidoModel = buscarPedidoService.buscarPedidoPorId(id);
		
		pedidoNaoEncontradoValidation.pedidoNaoEncontrado(pedidoModel);
		
		return pedidoMapper.toRecuperarPedidoDTO(pedidoModel);
		
	}

	@Override
	public RecuperarPedidoListResponseDTO buscarPedidoPorStatus(String status) {
		
		PedidoListModel pedidoListModel = buscarPedidoService.buscarPedidoPorStatus(status);
		
		pedidoNaoEncontradoValidation.pedidoNaoEncontrado(pedidoListModel);
		return pedidoMapper.toPedidoListDTO(pedidoListModel);
		
	}

}

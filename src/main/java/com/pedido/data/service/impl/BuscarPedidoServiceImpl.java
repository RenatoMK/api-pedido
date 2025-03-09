package com.pedido.data.service.impl;

import org.springframework.stereotype.Service;

import com.pedido.data.mapper.PedidoDataMapper;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.data.service.BuscarPedidoService;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuscarPedidoServiceImpl implements BuscarPedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	private final PedidoDataMapper pedidoMapper;
	
	public PedidoModel buscarPedidoPorId(Long id) {
		
		return pedidoMapper.toModel(pedidoRepository.findByIDPedidoDhExclusao(id));
		
	}

	@Override
	public PedidoListModel buscarPedidoPorStatus(String status) {
		
		return pedidoMapper.toPedidoListModel(pedidoRepository.findByStatusPedidoDhExclusao(status));
	
	}
}

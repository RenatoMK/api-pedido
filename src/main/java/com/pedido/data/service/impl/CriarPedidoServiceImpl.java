package com.pedido.data.service.impl;

import org.springframework.stereotype.Service;

import com.pedido.data.entity.PedidoEntity;
import com.pedido.data.entity.PedidoItemEntity;
import com.pedido.data.exception.BusinessInternalServerErrorException;
import com.pedido.data.mapper.PedidoDataMapper;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.data.service.CriarPedidoService;
import com.pedido.domain.model.PedidoModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CriarPedidoServiceImpl implements CriarPedidoService {
	
	private final PedidoDataMapper pedidoDataMapper;
	private final PedidoRepository pedidoRepository;

	@Override
	public PedidoModel criarPedido(PedidoModel pedidoModel) {
		
		PedidoEntity pedidoEntity =  pedidoDataMapper.toEntity(pedidoModel);
		pedidoEntity.setStatus("Criado");
		for(PedidoItemEntity pedidoItemEntity : pedidoEntity.getItens()) {
			pedidoItemEntity.setPedido(pedidoEntity);
		}
		try {
			PedidoEntity savedEntity = pedidoRepository.save(pedidoEntity);
			pedidoModel.setId(savedEntity.getId());
			pedidoModel.setStatus(savedEntity.getStatus());
			return pedidoModel;
		} catch (Exception e) {
			throw new BusinessInternalServerErrorException("Erro interno");
		}
	}
}

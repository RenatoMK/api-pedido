package com.pedido.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.domain.model.PedidoModel;

@Mapper
public interface PedidoMapper {

	PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
	
	PedidoModel toModel(PedidoRequestDTO pedidoRequestDTO);
	
	PedidoRequestDTO toDTO(PedidoModel pedidoModel);
	
}

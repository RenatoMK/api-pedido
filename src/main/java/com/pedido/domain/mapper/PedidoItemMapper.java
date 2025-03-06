package com.pedido.domain.mapper;

import org.mapstruct.Mapper;

import com.pedido.api.dto.PedidoItemRequestDTO;
import com.pedido.domain.model.PedidoItemModel;

@Mapper(componentModel = "spring")
public interface PedidoItemMapper {

	PedidoItemModel toModel(PedidoItemRequestDTO pedidoItemRequestDTO);
	
}

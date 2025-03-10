package com.pedido.domain.mapper;

import org.mapstruct.Mapper;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.domain.model.PedidoItemModel;

@Mapper(componentModel = "spring")
public interface PedidoDomainItemMapper {
	
	PedidoItemModel toModel(CriarPedidoItemRequestDTO pedidoItemRequestDTO);

}

package com.pedido.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pedido.data.entity.PedidoItemEntity;
import com.pedido.domain.model.PedidoItemModel;

@Mapper(componentModel = "spring")
public interface PedidoDataItemMapper {

	@Mapping(target = "dhInclusao", expression = "java(java.time.LocalDateTime.now())")
	PedidoItemEntity toEntity(PedidoItemModel pedidoItemModel);
	
	PedidoItemModel toModel(PedidoItemEntity pedidoItemEntity);
	
}

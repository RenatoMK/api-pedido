package com.pedido.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pedido.api.dto.PedidoItemRequestDTO;
import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.domain.model.PedidoItemModel;
import com.pedido.domain.model.PedidoModel;

@Mapper(componentModel = "spring", uses = {PedidoItemMapper.class})
public interface PedidoMapper {
	
	PedidoModel toModel(PedidoRequestDTO pedidoRequestDTO);
	
	PedidoRequestDTO toDTO(PedidoModel pedidoModel);
	
	List<PedidoItemModel> mapItens(List<PedidoItemRequestDTO> itens);
}

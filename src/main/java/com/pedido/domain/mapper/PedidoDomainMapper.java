package com.pedido.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;
import com.pedido.domain.model.PedidoItemModel;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;

@Mapper(componentModel = "spring", uses = {PedidoDomainItemMapper.class})
public interface PedidoDomainMapper {

	PedidoModel toModel(PedidoDTO pedidoRequestDTO);

	List<PedidoItemModel> itensToModel(List<CriarPedidoItemRequestDTO> itens);
	
	CriarPedidoResponseDTO toCriarPedidoDTO(PedidoModel pedidoModel);
	
	RecuperarPedidoResponseDTO toRecuperarPedidoDTO(PedidoModel pedidoModel);

	List<CriarPedidoItemRequestDTO> itensToDTO(List<PedidoItemModel> itens);
	
	RecuperarPedidoListResponseDTO toPedidoListDTO(PedidoListModel pedidoListModel);


}

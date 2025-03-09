package com.pedido.data.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pedido.data.entity.PedidoEntity;
import com.pedido.data.entity.PedidoItemEntity;
import com.pedido.domain.model.PedidoItemModel;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;

@Mapper(componentModel = "spring", uses = {PedidoDataItemMapper.class})
public interface PedidoDataMapper {
	
	@Mapping(target = "dhInclusao", expression = "java(java.time.LocalDateTime.now())")
	PedidoEntity toEntity(PedidoModel pedidoModel);
	
	List<PedidoItemEntity> itensToEntity(List<PedidoItemModel> itens);
	
	PedidoModel toModel(PedidoEntity pedidoEntity);
	
	List<PedidoItemModel> itensToModel(List<PedidoItemEntity> itens);
	
	List<PedidoModel> toListModel(List<PedidoEntity> pedidoEntityList);
	
    default PedidoListModel toPedidoListModel(List<PedidoEntity> pedidoEntityList) {
        PedidoListModel listModel = new PedidoListModel();
        listModel.setPedidos(toListModel(pedidoEntityList));
        return listModel;
    }
}

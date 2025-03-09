package com.pedido.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

    private Long pedidoId;
    private Long clienteId;
    private List<PedidoItemDTO> itens;
    
}

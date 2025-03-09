package com.pedido.api.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDTO {
    private Long produtoId;
    private Long quantidade;
    private BigDecimal valor;

}

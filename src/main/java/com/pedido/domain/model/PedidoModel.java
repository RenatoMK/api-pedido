package com.pedido.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoModel implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long pedidoId;
    private Long clienteId;
    private String status;
    private Long id;
    private BigDecimal imposto;
    private List<PedidoItemModel> itens;
}

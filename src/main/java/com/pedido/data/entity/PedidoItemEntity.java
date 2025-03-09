package com.pedido.data.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pedidos_item", indexes = {
	    @Index(name = "idx_dh_Exclusao_pie", columnList = "dh_Exclusao")
	})
public class PedidoItemEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido_item;
    
    @ManyToOne 
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoEntity pedido;
    
    @Column(name = "produto_Id", nullable = false)
    private Long produtoId;
    
    @Column(name = "quantidade", nullable = false)
    private Long quantidade;
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime dhInclusao;
    
    @Column(name = "dh_alteracao")
    private LocalDateTime dhAlteracao;

    @Column(name = "dh_Exclusao")
    private LocalDateTime dhExclusao;
    
}

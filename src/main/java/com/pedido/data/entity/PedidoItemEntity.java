package com.pedido.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PedidoItemEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne 
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;
    
    @Column(name = "produto_Id", nullable = false)
    private Long produtoId;
    
    @Column(name = "quantidade", nullable = false)
    private Long quantidade;
    
    @Column(name = "valor", nullable = false)
    private Double valor;

}

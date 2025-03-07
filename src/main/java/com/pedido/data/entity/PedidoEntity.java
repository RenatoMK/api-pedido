package com.pedido.data.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PedidoEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "pedido_id", unique = true, nullable = false)
    private Long pedidoId;
    
    @Column(name = "cliente_Id", nullable = false)
    private Long clienteId;
    
    @Column(name = "imposto", nullable = false)
    private Double imposto;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @OneToMany(mappedBy = "produtoId", cascade = CascadeType.ALL)
    private List<PedidoItemEntity> itens;

}
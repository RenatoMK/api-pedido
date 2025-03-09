package com.pedido.data.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pedido", indexes = {
	    @Index(name = "idx_dh_Exclusao_p", columnList = "dh_Exclusao")
	})
public class PedidoEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido", nullable = false)
    private Long id;
    
    @Column(name = "pedido_id", unique = true, nullable = false)
    private Long pedidoId;
    
    @Column(name = "cliente_Id", nullable = false)
    private Long clienteId;
    
    @Column(name = "imposto", nullable = false)
    private BigDecimal imposto;
    
    @Column(name = "status")
    private String status;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoItemEntity> itens = new ArrayList<>();
    
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime dhInclusao;
    
    @Column(name = "dh_alteracao")
    private LocalDateTime dhAlteracao;

    @Column(name = "dh_Exclusao")
    private LocalDateTime dhExclusao;
    
}
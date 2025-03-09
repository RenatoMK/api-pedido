package com.pedido.data.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "parametro_imposto",  indexes = {
	    @Index(name = "idx_dh_Exclusao_pi", columnList = "dh_Exclusao")
	})
public class ParametroImpostoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parametro_imposto;
    
    @Column(name = "taxa_imposto", unique = true, nullable = false)
    private BigDecimal taxaImposto;
    
    @Column(name = "descricao_imposto")
    private String descricaoImposto;
    
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime dhInclusao;
    
    @Column(name = "dh_alteracao")
    private LocalDateTime dhAlteracao;

    @Column(name = "dh_Exclusao")
    private LocalDateTime dhExclusao;
    
}

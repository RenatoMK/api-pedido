package com.pedido.data.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pedido.data.entity.ParametroImpostoEntity;

public interface ParametroImpostoRepository extends JpaRepository<ParametroImpostoEntity, Long> {

	@Query(value = "select TAXA_IMPOSTO from PARAMETRO_IMPOSTO where DH_EXCLUSAO is null", nativeQuery = true)
	BigDecimal recuperaParametroImposto();

	@Query(value = " select ID_PARAMETRO_IMPOSTO, DESCRICAO_IMPOSTO, DH_ALTERACAO, DH_EXCLUSAO, DH_INCLUSAO, "
			+ "TAXA_IMPOSTO  from PARAMETRO_IMPOSTO where DH_EXCLUSAO is null", nativeQuery = true)
	ParametroImpostoEntity recuperarRegistroParametroImposto();
	
}

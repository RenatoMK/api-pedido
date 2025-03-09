package com.pedido.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pedido.data.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	@Query(value = "select id_pedido, cliente_Id, dh_alteracao, dh_Exclusao, dh_inclusao, "
			+ "imposto, pedido_id, status from pedido where pedido_id = :pedidoId and dh_Exclusao is null", nativeQuery = true)
	PedidoEntity findByPedidoIdDhExclusao(@Param("pedidoId") Long pedidoId);
	
	@Query(value = "select id_pedido, cliente_Id, dh_alteracao, dh_Exclusao, dh_inclusao, "
			+ "imposto, pedido_id, status from pedido where id_pedido = :idPedidoId and dh_Exclusao is null", nativeQuery = true)
	PedidoEntity findByIDPedidoDhExclusao(@Param("idPedidoId") Long idPedidoId);
	
	@Query(value = " SELECT id_pedido, cliente_Id, dh_alteracao, dh_Exclusao, dh_inclusao, "
			+ "	imposto, pedido_id, status  FROM PEDIDO WHERE (:status IS NULL OR :status = '' OR status = :status);", nativeQuery = true)
	List<PedidoEntity> findByStatusPedidoDhExclusao(@Param("status") String status);

}

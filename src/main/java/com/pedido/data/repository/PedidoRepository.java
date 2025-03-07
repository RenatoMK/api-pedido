package com.pedido.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.data.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

	PedidoEntity findByPedidoId(Long pedidoId);
	
}

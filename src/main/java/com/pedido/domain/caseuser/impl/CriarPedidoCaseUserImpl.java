package com.pedido.domain.caseuser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.api.dto.PedidoResponseDTO;
import com.pedido.data.entity.PedidoEntity;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;
import com.pedido.domain.mapper.PedidoMapper;
import com.pedido.domain.model.PedidoModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CriarPedidoCaseUserImpl implements CriarPedidoCaseUser {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {
		
		PedidoModel pedidoModel = PedidoMapper.INSTANCE.toModel(pedidoRequestDTO);
		
//		validarDuplicidade(pedidoRequestDTO.getPedidoId());
//		calcularImposto(pedidoRequestDTO);
		
		PedidoEntity PedidoEntity = new PedidoEntity();
		
		 pedidoRepository.save(PedidoEntity);
		 PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
		 return pedidoResponseDTO;
	}

//	private void validarDuplicidade(Long pedidoId) {
//		if (pedidoRepository.existsByPedidoId(pedidoId)) {
//			throw new IllegalArgumentException("Pedido duplicado");
//		}
//	}
//
//	private void calcularImposto(PedidoRequestDTO pedidoRequestDTO) {
//        double valorTotal = pedidoRequestDTO.getItens().stream()
//                .mapToDouble(item -> item.getQuantidade() * item.getValor())
//                .sum();
//        pedidoRequestDTO.setImposto(valorTotal * 0.3); // Feature Flag pode alterar para 0.2
//    }
}
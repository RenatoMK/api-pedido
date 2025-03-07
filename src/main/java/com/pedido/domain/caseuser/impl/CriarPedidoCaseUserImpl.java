package com.pedido.domain.caseuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.api.dto.PedidoResponseDTO;
import com.pedido.data.entity.PedidoEntity;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;
import com.pedido.domain.mapper.PedidoMapper;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.validation.PedidoValidation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor 
public class CriarPedidoCaseUserImpl implements CriarPedidoCaseUser {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoMapper pedidoMapper;
	
	@Autowired
	private List<PedidoValidation> pedidoValidationList;
	
	@Override
	public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {
		
		PedidoModel pedidoModel = pedidoMapper.toModel(pedidoRequestDTO);
		
		//Validações
		for(PedidoValidation pedidoValidation : pedidoValidationList) {
			pedidoValidation.validaPedido(pedidoRequestDTO);
		}
		
		
//		validarDuplicidade(pedidoRequestDTO.getPedidoId());
//		calcularImposto(pedidoRequestDTO);
		
//		PedidoEntity PedidoEntity = new PedidoEntity();
		
//		 pedidoRepository.save(PedidoEntity);
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
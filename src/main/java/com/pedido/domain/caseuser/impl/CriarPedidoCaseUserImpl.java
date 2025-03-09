package com.pedido.domain.caseuser.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.data.service.CriarPedidoService;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;
import com.pedido.domain.mapper.PedidoDomainMapper;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.service.CalcularImpostoService;
import com.pedido.domain.validation.PedidoValidation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CriarPedidoCaseUserImpl implements CriarPedidoCaseUser {

	private final PedidoDomainMapper pedidoModelMapper;

	private final List<PedidoValidation> pedidoValidationList;

	private final CalcularImpostoService calcularImpostoService;

	private final CriarPedidoService criarPedidoService;

	@Override
	public CriarPedidoResponseDTO criarPedido(CriarPedidoItemRequestDTO criarPedidoItemRequestDTO) {

		for (PedidoValidation pedidoValidation : pedidoValidationList) {
			pedidoValidation.validaPedido(criarPedidoItemRequestDTO);
		}
		
		PedidoModel pedidoModel = pedidoModelMapper.toModel(criarPedidoItemRequestDTO);
		pedidoModel = calcularImpostoService.calcularImposto(pedidoModel);
		pedidoModel = criarPedidoService.criarPedido(pedidoModel);

		CriarPedidoResponseDTO pedidoResponseDTO = pedidoModelMapper.toCriarPedidoDTO(pedidoModel);
		
		log.info("Finaliza Criacao Pedido " + criarPedidoItemRequestDTO.getPedidoId());
		return pedidoResponseDTO;
	}

}
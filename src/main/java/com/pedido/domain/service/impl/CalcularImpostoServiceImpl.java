package com.pedido.domain.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.pedido.data.service.RecuperarTaxaImpostoCacheService;
import com.pedido.domain.model.PedidoItemModel;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.service.CalcularImpostoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalcularImpostoServiceImpl implements CalcularImpostoService {

	private final RecuperarTaxaImpostoCacheService recuperarTaxaImpostoCacheService;
	
	@Override
	public PedidoModel calcularImposto(PedidoModel pedidoModel) {
		
		BigDecimal valorItens = new BigDecimal(0);
		for(PedidoItemModel pedidoItemModel : pedidoModel.getItens()) {
			valorItens = valorItens.add(pedidoItemModel.getValor());
		}
		
		BigDecimal taxaImposto = recuperarTaxaImpostoCacheService.recuperaParametroImposto();
		
		pedidoModel.setImposto(valorItens.multiply(taxaImposto).setScale(2, RoundingMode.HALF_UP));
		
		return pedidoModel;
	}
	

}

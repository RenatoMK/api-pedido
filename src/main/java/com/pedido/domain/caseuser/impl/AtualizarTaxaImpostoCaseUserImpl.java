package com.pedido.domain.caseuser.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.pedido.data.service.AtualizarTaxaImpostoService;
import com.pedido.domain.caseuser.AtualizarTaxaImpostoCaseUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AtualizarTaxaImpostoCaseUserImpl implements AtualizarTaxaImpostoCaseUser {

	private final AtualizarTaxaImpostoService atualizarTaxaImpostoService;
	
	@Override
	public void atualizarTaxaImposto(BigDecimal taxaImposto, String descriçãoImposto) {
		atualizarTaxaImpostoService.atualizarTaxaImposto(taxaImposto, descriçãoImposto);
	}

}

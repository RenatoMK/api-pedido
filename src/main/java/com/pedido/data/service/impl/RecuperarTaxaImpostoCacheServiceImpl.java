package com.pedido.data.service.impl;

import java.math.BigDecimal;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pedido.data.repository.ParametroImpostoRepository;
import com.pedido.data.service.RecuperarTaxaImpostoCacheService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecuperarTaxaImpostoCacheServiceImpl implements RecuperarTaxaImpostoCacheService {

	private final ParametroImpostoRepository parametroImpostoRepository;

	@Cacheable(value = "taxaImpostoCache", key = "'taxa'")
	public BigDecimal recuperaParametroImposto() {
		log.info("Cria cache paramentro taxa imposto");
		return parametroImpostoRepository.recuperaParametroImposto();
	}

}

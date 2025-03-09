package com.pedido.data.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.pedido.data.entity.ParametroImpostoEntity;
import com.pedido.data.exception.BusinessInternalServerErrorException;
import com.pedido.data.repository.ParametroImpostoRepository;
import com.pedido.data.service.AtualizarTaxaImpostoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AtualizarTaxaImpostoServiceImpl implements AtualizarTaxaImpostoService{
	
	private final ParametroImpostoRepository parametroImpostoRepository;

	@Override
	@Transactional
	public void atualizarTaxaImposto(BigDecimal taxaImposto, String descriçãoImposto) {

		ParametroImpostoEntity parametroImpostoEntity = parametroImpostoRepository.recuperarRegistroParametroImposto();
		parametroImpostoEntity.setDhAlteracao(LocalDateTime.now());
		parametroImpostoEntity.setDhExclusao(LocalDateTime.now());
		
		ParametroImpostoEntity novoParametroImpostoEntity = new ParametroImpostoEntity();
		novoParametroImpostoEntity.setDescricaoImposto(descriçãoImposto);
		novoParametroImpostoEntity.setDhInclusao(LocalDateTime.now());
		novoParametroImpostoEntity.setTaxaImposto(taxaImposto);
		try {
			parametroImpostoRepository.save(parametroImpostoEntity);
			parametroImpostoRepository.save(novoParametroImpostoEntity);
		}catch (Exception e) {
			throw new BusinessInternalServerErrorException("Erro interno");
		}
	}
	


}

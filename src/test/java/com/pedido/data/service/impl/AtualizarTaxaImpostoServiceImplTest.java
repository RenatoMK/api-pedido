package com.pedido.data.service.impl;

import com.pedido.data.entity.ParametroImpostoEntity;
import com.pedido.data.exception.BusinessInternalServerErrorException;
import com.pedido.data.repository.ParametroImpostoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtualizarTaxaImpostoServiceImplTest {

    @Mock
    private ParametroImpostoRepository parametroImpostoRepository;

    @InjectMocks
    private AtualizarTaxaImpostoServiceImpl atualizarTaxaImpostoServiceImpl;

    private ParametroImpostoEntity parametroImpostoEntity;
    private BigDecimal taxaImposto;
    private String descricaoImposto;

    @BeforeEach
    void setUp() {
        taxaImposto = BigDecimal.valueOf(0.5);
        descricaoImposto = "Nova taxa de imposto";

        parametroImpostoEntity = new ParametroImpostoEntity();
        parametroImpostoEntity.setTaxaImposto(BigDecimal.valueOf(0.2));
        parametroImpostoEntity.setDescricaoImposto("Taxa antiga");
        parametroImpostoEntity.setDhInclusao(LocalDateTime.now());
    }

    @Test
    void testAtualizarTaxaImposto() {
       
    	when(parametroImpostoRepository.recuperarRegistroParametroImposto()).thenReturn(parametroImpostoEntity);

        atualizarTaxaImpostoServiceImpl.atualizarTaxaImposto(taxaImposto, descricaoImposto);

        verify(parametroImpostoRepository, times(1)).recuperarRegistroParametroImposto();
        verify(parametroImpostoRepository, times(2)).save(any(ParametroImpostoEntity.class));

    }

	@Test
    void testAtualizarTaxaImpostoComErro() {

		when(parametroImpostoRepository.recuperarRegistroParametroImposto()).thenReturn(parametroImpostoEntity);
        doThrow(new RuntimeException("Erro ao salvar")).when(parametroImpostoRepository).save(any(ParametroImpostoEntity.class));

        assertThrows(BusinessInternalServerErrorException.class, () -> {
            atualizarTaxaImpostoServiceImpl.atualizarTaxaImposto(taxaImposto, descricaoImposto);
        });

    }
}
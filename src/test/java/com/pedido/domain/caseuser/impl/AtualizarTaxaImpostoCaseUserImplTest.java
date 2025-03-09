package com.pedido.domain.caseuser.impl;

import com.pedido.data.service.AtualizarTaxaImpostoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtualizarTaxaImpostoCaseUserImplTest {

    @Mock
    private AtualizarTaxaImpostoService atualizarTaxaImpostoService;

    @InjectMocks
    private AtualizarTaxaImpostoCaseUserImpl atualizarTaxaImpostoCaseUserImpl;

    private BigDecimal taxaImposto;
    private String descricaoImposto;

    @BeforeEach
    void setUp() {
        taxaImposto = BigDecimal.valueOf(0.5);
        descricaoImposto = "Nova taxa de imposto";
    }

    @Test
    void testAtualizarTaxaImposto() {
        
    	atualizarTaxaImpostoCaseUserImpl.atualizarTaxaImposto(taxaImposto, descricaoImposto);
        
    	verify(atualizarTaxaImpostoService, times(1)).atualizarTaxaImposto(taxaImposto, descricaoImposto);
    
    }

    @Test
    void testAtualizarTaxaImpostoComErro() {

    	doThrow(new RuntimeException("Erro ao atualizar taxa")).when(atualizarTaxaImpostoService)
                .atualizarTaxaImposto(taxaImposto, descricaoImposto);

        assertThrows(RuntimeException.class, () -> {
            atualizarTaxaImpostoCaseUserImpl.atualizarTaxaImposto(taxaImposto, descricaoImposto);
        });

        verify(atualizarTaxaImpostoService, times(1)).atualizarTaxaImposto(taxaImposto, descricaoImposto);
    }
}
package com.pedido.domain.service.impl;

import com.pedido.data.service.RecuperarTaxaImpostoCacheService;
import com.pedido.domain.model.PedidoItemModel;
import com.pedido.domain.model.PedidoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalcularImpostoServiceImplTest {

    @Mock
    private RecuperarTaxaImpostoCacheService recuperarTaxaImpostoCacheService;

    @InjectMocks
    private CalcularImpostoServiceImpl calcularImpostoServiceImpl;

    private PedidoModel pedidoModel;
    private PedidoItemModel item1;
    private PedidoItemModel item2;

    @BeforeEach
    void setUp() {
        item1 = new PedidoItemModel();
        item1.setValor(BigDecimal.valueOf(100.00));

        item2 = new PedidoItemModel();
        item2.setValor(BigDecimal.valueOf(200.00));

        pedidoModel = new PedidoModel();
        pedidoModel.setItens(Arrays.asList(item1, item2));
    }

    @Test
    void testCalcularImposto() {
    	
        BigDecimal taxaImposto = BigDecimal.valueOf(0.1); 
        when(recuperarTaxaImpostoCacheService.recuperaParametroImposto()).thenReturn(taxaImposto);

        PedidoModel resultado = calcularImpostoServiceImpl.calcularImposto(pedidoModel);

        assertEquals(BigDecimal.valueOf(30.00).setScale(2), resultado.getImposto()); 
    }


    @Test
    void testCalcularImpostoComTaxaZero() {
        
    	BigDecimal taxaImposto = BigDecimal.ZERO; 
        when(recuperarTaxaImpostoCacheService.recuperaParametroImposto()).thenReturn(taxaImposto);

        PedidoModel resultado = calcularImpostoServiceImpl.calcularImposto(pedidoModel);

        assertEquals(BigDecimal.ZERO.setScale(2), resultado.getImposto()); 
        verify(recuperarTaxaImpostoCacheService, times(1)).recuperaParametroImposto();
    }
}
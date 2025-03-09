package com.pedido.domain.caseuser.impl;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.data.producer.PedidoProducer;
import com.pedido.data.service.CriarPedidoService;
import com.pedido.domain.mapper.PedidoDomainMapper;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.service.CalcularImpostoService;
import com.pedido.domain.validation.PedidoValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CriarPedidoCaseUserImplTest {

    @Mock
    private PedidoDomainMapper pedidoModelMapper;

    @Mock
    private List<PedidoValidation> pedidoValidationList;

    @Mock
    private CalcularImpostoService calcularImpostoService;

    @Mock
    private CriarPedidoService criarPedidoService;

    @Mock
    private PedidoProducer pedidoProducer;

    @InjectMocks
    private CriarPedidoCaseUserImpl criarPedidoCaseUserImpl;

    private CriarPedidoItemRequestDTO criarPedidoItemRequestDTO;
    private PedidoModel pedidoModel;
    private CriarPedidoResponseDTO criarPedidoResponseDTO;

    @BeforeEach
    void setUp() {

    	criarPedidoItemRequestDTO = new CriarPedidoItemRequestDTO();
        pedidoModel = new PedidoModel();
        criarPedidoResponseDTO = new CriarPedidoResponseDTO();

        when(pedidoModelMapper.toModel(criarPedidoItemRequestDTO)).thenReturn(pedidoModel);
        when(calcularImpostoService.calcularImposto(pedidoModel)).thenReturn(pedidoModel);
        when(criarPedidoService.criarPedido(pedidoModel)).thenReturn(pedidoModel);
        when(pedidoModelMapper.toCriarPedidoDTO(pedidoModel)).thenReturn(criarPedidoResponseDTO);
    }

    @Test
    void testCriarPedido() {
        
    	PedidoValidation pedidoValidation = mock(PedidoValidation.class);
        when(pedidoValidationList.iterator()).thenReturn(Collections.singletonList(pedidoValidation).iterator());

        CriarPedidoResponseDTO response = criarPedidoCaseUserImpl.criarPedido(criarPedidoItemRequestDTO);

        assertEquals(criarPedidoResponseDTO, response);

        verify(pedidoValidation, times(1)).validaPedido(criarPedidoItemRequestDTO);
        verify(pedidoModelMapper, times(1)).toModel(criarPedidoItemRequestDTO);
        verify(calcularImpostoService, times(1)).calcularImposto(pedidoModel);
        verify(criarPedidoService, times(1)).criarPedido(pedidoModel);
        verify(pedidoProducer, times(1)).enviarMensagem(pedidoModel);
        verify(pedidoModelMapper, times(1)).toCriarPedidoDTO(pedidoModel);
    }

    @Test
    void testCriarPedidoComValidacoesMultiplas() {

    	PedidoValidation pedidoValidation1 = mock(PedidoValidation.class);
        PedidoValidation pedidoValidation2 = mock(PedidoValidation.class);
        when(pedidoValidationList.iterator()).thenReturn(List.of(pedidoValidation1, pedidoValidation2).iterator());

        CriarPedidoResponseDTO response = criarPedidoCaseUserImpl.criarPedido(criarPedidoItemRequestDTO);

        assertEquals(criarPedidoResponseDTO, response);

        verify(pedidoValidation1, times(1)).validaPedido(criarPedidoItemRequestDTO);
        verify(pedidoValidation2, times(1)).validaPedido(criarPedidoItemRequestDTO);
    }
}
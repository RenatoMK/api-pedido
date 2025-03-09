package com.pedido.domain.validation.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.data.repository.PedidoRepository;

@ExtendWith(MockitoExtension.class)
class PedidoDuplicadovalidationImplTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoDuplicadovalidationImpl pedidoDuplicadovalidationImpl;

    private CriarPedidoItemRequestDTO criarPedidoItemRequestDTO;

    @BeforeEach
    void setUp() {
        criarPedidoItemRequestDTO = new CriarPedidoItemRequestDTO();
        criarPedidoItemRequestDTO.setPedidoId(1L);
    }

    @Test
    void testValidaPedidoComPedidoNaoDuplicado() {

    	when(pedidoRepository.findByPedidoIdDhExclusao(1L)).thenReturn(null); 

        pedidoDuplicadovalidationImpl.validaPedido(criarPedidoItemRequestDTO);

        verify(pedidoRepository, times(1)).findByPedidoIdDhExclusao(1L);
    }
}
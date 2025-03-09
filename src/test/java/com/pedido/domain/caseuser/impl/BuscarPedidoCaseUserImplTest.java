package com.pedido.domain.caseuser.impl;

import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;
import com.pedido.data.service.BuscarPedidoService;
import com.pedido.domain.mapper.PedidoDomainMapper;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;
import com.pedido.domain.validation.PedidoNaoEncontradoValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BuscarPedidoCaseUserImplTest {

    @Mock
    private BuscarPedidoService buscarPedidoService;

    @Mock
    private PedidoDomainMapper pedidoMapper;

    @Mock
    private PedidoNaoEncontradoValidation pedidoNaoEncontradoValidation;

    @InjectMocks
    private BuscarPedidoCaseUserImpl buscarPedidoCaseUserImpl;

    private PedidoModel pedidoModel;
    private PedidoListModel pedidoListModel;
    private RecuperarPedidoResponseDTO recuperarPedidoResponseDTO;
    private RecuperarPedidoListResponseDTO recuperarPedidoListResponseDTO;

    @BeforeEach
    void setUp() {
        pedidoModel = new PedidoModel();
        pedidoModel.setId(1L);
        pedidoModel.setStatus("Criado");

        pedidoListModel = new PedidoListModel();

        recuperarPedidoResponseDTO = new RecuperarPedidoResponseDTO();
        recuperarPedidoResponseDTO.setId(1L);
        recuperarPedidoResponseDTO.setStatus("Criado");

        recuperarPedidoListResponseDTO = new RecuperarPedidoListResponseDTO();
    }

    @Test
    void testBuscarPedidoPorId() {

    	Long id = 1L;
        when(buscarPedidoService.buscarPedidoPorId(id)).thenReturn(pedidoModel);
        when(pedidoMapper.toRecuperarPedidoDTO(pedidoModel)).thenReturn(recuperarPedidoResponseDTO);

        RecuperarPedidoResponseDTO resultado = buscarPedidoCaseUserImpl.buscarPedidoPorId(id);

        assertEquals(recuperarPedidoResponseDTO, resultado);

    }

    @Test
    void testBuscarPedidoPorIdComPedidoNaoEncontrado() {

    	Long id = 1L;
        when(buscarPedidoService.buscarPedidoPorId(id)).thenReturn(null);
        doThrow(new RuntimeException("Pedido não encontrado")).when(pedidoNaoEncontradoValidation).pedidoNaoEncontrado(pedidoModel);

        assertThrows(RuntimeException.class, () -> {
            buscarPedidoCaseUserImpl.buscarPedidoPorId(id);
        });

    }

    @Test
    void testBuscarPedidoPorStatus() {

        String status = "Criado";
        when(buscarPedidoService.buscarPedidoPorStatus(status)).thenReturn(pedidoListModel);
        when(pedidoMapper.toPedidoListDTO(pedidoListModel)).thenReturn(recuperarPedidoListResponseDTO);

        RecuperarPedidoListResponseDTO resultado = buscarPedidoCaseUserImpl.buscarPedidoPorStatus(status);

        assertEquals(recuperarPedidoListResponseDTO, resultado);
    }

    @Test
    void testBuscarPedidoPorStatusComPedidoNaoEncontrado() {

    	String status = "Criado";
        when(buscarPedidoService.buscarPedidoPorStatus(status)).thenReturn(null);
        doThrow(new RuntimeException("Pedido não encontrado")).when(pedidoNaoEncontradoValidation).pedidoNaoEncontrado(pedidoListModel);

        assertThrows(RuntimeException.class, () -> {
            buscarPedidoCaseUserImpl.buscarPedidoPorStatus(status);
        });

    }
}
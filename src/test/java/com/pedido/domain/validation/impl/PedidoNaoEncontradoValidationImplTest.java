package com.pedido.domain.validation.impl;

import com.pedido.domain.exception.BusinessNotFoundException;
import com.pedido.domain.model.PedidoListModel;
import com.pedido.domain.model.PedidoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PedidoNaoEncontradoValidationImplTest {

    @InjectMocks
    private PedidoNaoEncontradoValidationImpl pedidoNaoEncontradoValidationImpl;

    private PedidoModel pedidoModel;
    private PedidoListModel pedidoListModel;

    @BeforeEach
    void setUp() {
        pedidoModel = new PedidoModel();
        pedidoModel.setId(1L);

        pedidoListModel = new PedidoListModel();
    }

    @Test
    void testPedidoNaoEncontradoComPedidoModelNulo() {

    	pedidoModel = null;

        BusinessNotFoundException exception = assertThrows(BusinessNotFoundException.class, () -> {
            pedidoNaoEncontradoValidationImpl.pedidoNaoEncontrado(pedidoModel);
        });

        assertEquals("Pedido não encontrado", exception.getMessage());
    }

    @Test
    void testPedidoNaoEncontradoComPedidoListModelVazio() {

    	pedidoListModel.setPedidos(Collections.emptyList());

        BusinessNotFoundException exception = assertThrows(BusinessNotFoundException.class, () -> {
            pedidoNaoEncontradoValidationImpl.pedidoNaoEncontrado(pedidoListModel);
        });

        assertEquals("Pedido não encontrado", exception.getMessage());
    }

}
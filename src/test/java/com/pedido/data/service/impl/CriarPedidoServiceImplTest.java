package com.pedido.data.service.impl;

import com.pedido.data.entity.PedidoEntity;
import com.pedido.data.entity.PedidoItemEntity;
import com.pedido.data.exception.BusinessInternalServerErrorException;
import com.pedido.data.mapper.PedidoDataMapper;
import com.pedido.data.repository.PedidoRepository;
import com.pedido.domain.model.PedidoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CriarPedidoServiceImplTest {

    @Mock
    private PedidoDataMapper pedidoDataMapper;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private CriarPedidoServiceImpl criarPedidoServiceImpl;

    private PedidoModel pedidoModel;
    private PedidoEntity pedidoEntity;
    private PedidoItemEntity pedidoItemEntity;

    @BeforeEach
    void setUp() {
        pedidoModel = new PedidoModel();
        pedidoModel.setId(1L);
        pedidoModel.setStatus("Criado");

        pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(1L);
        pedidoEntity.setStatus("Criado");

        pedidoItemEntity = new PedidoItemEntity();
        pedidoEntity.setItens(Collections.singletonList(pedidoItemEntity));
    }

    @Test
    void testCriarPedido() {

    	when(pedidoDataMapper.toEntity(pedidoModel)).thenReturn(pedidoEntity);
        when(pedidoRepository.save(pedidoEntity)).thenReturn(pedidoEntity);

        PedidoModel resultado = criarPedidoServiceImpl.criarPedido(pedidoModel);

        assertNotNull(resultado);
        assertEquals(pedidoModel.getId(), resultado.getId());
        assertEquals(pedidoModel.getStatus(), resultado.getStatus());
        assertEquals("Criado", pedidoEntity.getStatus());

    }

    @Test
    void testCriarPedidoComErro() {

    	when(pedidoDataMapper.toEntity(pedidoModel)).thenReturn(pedidoEntity);
        when(pedidoRepository.save(pedidoEntity)).thenThrow(new RuntimeException("Erro ao salvar"));

        assertThrows(BusinessInternalServerErrorException.class, () -> {
            criarPedidoServiceImpl.criarPedido(pedidoModel);
        });
    }
}
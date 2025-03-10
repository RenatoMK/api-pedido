package com.pedido.domain.validation.impl;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.PedidoItemDTO;
import com.pedido.domain.exception.BusinessBadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CamposValidationImplTest {

    @InjectMocks
    private CamposValidationImpl camposValidationImpl;

    private CriarPedidoItemRequestDTO criarPedidoItemRequestDTO;
    private PedidoItemDTO pedidoItemDTO;

    @BeforeEach
    void setUp() {
        pedidoItemDTO = new PedidoItemDTO();
        pedidoItemDTO.setProdutoId(1L);
        pedidoItemDTO.setQuantidade(2L);
        pedidoItemDTO.setValor(BigDecimal.valueOf(100.00));

        criarPedidoItemRequestDTO = new CriarPedidoItemRequestDTO();
        criarPedidoItemRequestDTO.setClienteId(1L);
        criarPedidoItemRequestDTO.setPedidoId(1L);
        criarPedidoItemRequestDTO.setItens(Arrays.asList(pedidoItemDTO));
    }

    @Test
    void testValidaPedidoComClienteIdNulo() {

    	criarPedidoItemRequestDTO.setClienteId(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("ClienteId não pode ser null", exception.getMessage());
    }

    @Test
    void testValidaPedidoComPedidoIdNulo() {

    	criarPedidoItemRequestDTO.setPedidoId(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("PedidoId não pode ser null", exception.getMessage());
    }

    @Test
    void testValidaPedidoComItensNulos() {

    	criarPedidoItemRequestDTO.setItens(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("Itens não pode ser null/vazio", exception.getMessage());
    }

    @Test
    void testValidaPedidoComItensVazios() {

    	criarPedidoItemRequestDTO.setItens(Collections.emptyList());

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("Itens não pode ser null/vazio", exception.getMessage());
    }

    @Test
    void testValidaPedidoComProdutoIdNulo() {

    	pedidoItemDTO.setProdutoId(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("ProdutoId não pode ser null", exception.getMessage());
    }

    @Test
    void testValidaPedidoComQuantidadeNula() {

    	pedidoItemDTO.setQuantidade(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("Quantidade não pode ser null", exception.getMessage());
    }

    @Test
    void testValidaPedidoComValorNulo() {

        pedidoItemDTO.setValor(null);

        BusinessBadRequestException exception = assertThrows(BusinessBadRequestException.class, () -> {
            camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
        });

        assertEquals("Valor não pode ser null", exception.getMessage());
    }

    @Test
    void testValidaPedidoComTodosCamposValidos() {

    	camposValidationImpl.validaPedido(criarPedidoItemRequestDTO);
    
    }
}
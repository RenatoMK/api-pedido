package com.pedido.api;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;
import com.pedido.domain.caseuser.AtualizarTaxaImpostoCaseUser;
import com.pedido.domain.caseuser.BuscarPedidoCaseUser;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PedidoApiTest {

    @Mock
    private CriarPedidoCaseUser criarPedidoCaseUser;

    @Mock
    private BuscarPedidoCaseUser buscarPedidoCaseUser;

    @Mock
    private AtualizarTaxaImpostoCaseUser atualizarTaxaImpostoCaseUser;

    @InjectMocks
    private PedidoApi pedidoApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarPedido() {
        CriarPedidoItemRequestDTO requestDTO = new CriarPedidoItemRequestDTO();
        CriarPedidoResponseDTO responseDTO = new CriarPedidoResponseDTO();
        when(criarPedidoCaseUser.criarPedido(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<CriarPedidoResponseDTO> response = pedidoApi.criarPedido(requestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
        verify(criarPedidoCaseUser, times(1)).criarPedido(requestDTO);
    }

    @Test
    void testBuscarPedidoPorId() {
    	
        Long id = 1L;
        RecuperarPedidoResponseDTO responseDTO = new RecuperarPedidoResponseDTO();
        when(buscarPedidoCaseUser.buscarPedidoPorId(id)).thenReturn(responseDTO);

        ResponseEntity<RecuperarPedidoResponseDTO> response = pedidoApi.buscarPedidoPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
        verify(buscarPedidoCaseUser, times(1)).buscarPedidoPorId(id);
    }

    @Test
    void testBuscarPedidoPorStatus() {

    	String status = "Criado";
        RecuperarPedidoListResponseDTO responseDTO = new RecuperarPedidoListResponseDTO();
        when(buscarPedidoCaseUser.buscarPedidoPorStatus(status)).thenReturn(responseDTO);

        ResponseEntity<RecuperarPedidoListResponseDTO> response = pedidoApi.buscarPedidoPorStatus(status);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
        verify(buscarPedidoCaseUser, times(1)).buscarPedidoPorStatus(status);
    }

    @Test
    void testAtualizarTaxaImposto() {

        BigDecimal taxaImposto = BigDecimal.valueOf(0.5);
        String descricaoImposto = "Atualização taxa";

        ResponseEntity<Void> response = pedidoApi.atualizarTaxaImposto(taxaImposto, descricaoImposto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(atualizarTaxaImpostoCaseUser, times(1)).atualizarTaxaImposto(taxaImposto, descricaoImposto);
    }
}
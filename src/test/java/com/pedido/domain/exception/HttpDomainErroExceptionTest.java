package com.pedido.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pedido.domain.model.ErroModel;

@ExtendWith(MockitoExtension.class)
class HttpDomainErroExceptionTest {

    @InjectMocks
    private HttpDomainErroException httpDomainErroException;

    private BusinessNotFoundException businessNotFoundException;
    private BusinessBadRequestException businessBadRequestException;

    @BeforeEach
    void setUp() {
        businessNotFoundException = new BusinessNotFoundException("Pedido não encontrado");
        businessBadRequestException = new BusinessBadRequestException("Requisição inválida");
    }

    @Test
    void testBusinessNotFound() {

    	ResponseEntity<?> response = httpDomainErroException.businessNotFound(businessNotFoundException);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        ErroModel erroModel = (ErroModel) response.getBody();
        assertNotNull(erroModel);
        assertEquals(HttpStatus.NOT_FOUND.value(), erroModel.getErroCode());
        assertEquals(HttpStatus.NOT_FOUND.toString(), erroModel.getDetails());
        assertEquals("Pedido não encontrado", erroModel.getMensagem());
        assertNotNull(erroModel.getTimestamp());
    }

    @Test
    void testBusinessBadRequest() {

    	ResponseEntity<?> response = httpDomainErroException.businessBadRequest(businessBadRequestException);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        ErroModel erroModel = (ErroModel) response.getBody();
        assertNotNull(erroModel);
        assertEquals(HttpStatus.BAD_REQUEST.value(), erroModel.getErroCode());
        assertEquals(HttpStatus.BAD_REQUEST.toString(), erroModel.getDetails());
        assertEquals("Requisição inválida", erroModel.getMensagem());
        assertNotNull(erroModel.getTimestamp());
    }
}
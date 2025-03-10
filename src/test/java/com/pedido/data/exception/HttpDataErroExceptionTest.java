package com.pedido.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pedido.domain.exception.BusinessBadRequestException;
import com.pedido.domain.model.ErroModel;

@ExtendWith(MockitoExtension.class)
class HttpDataErroExceptionTest {

    @InjectMocks
    private HttpDataErroException httpDataErroException;

    private BusinessBadRequestException businessBadRequestException;

    @BeforeEach
    void setUp() {
        businessBadRequestException = new BusinessBadRequestException("Erro de negócio");
    }

    @Test
    void testBusinessInternalServer() {

    	ResponseEntity<?> response = httpDataErroException.businessInternalServer(businessBadRequestException);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        ErroModel erroModel = (ErroModel) response.getBody();
        assertNotNull(erroModel);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), erroModel.getErroCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.toString(), erroModel.getDetails());
        assertEquals("Erro interno", erroModel.getMensagem());
        assertNotNull(erroModel.getTimestamp());
    }
}
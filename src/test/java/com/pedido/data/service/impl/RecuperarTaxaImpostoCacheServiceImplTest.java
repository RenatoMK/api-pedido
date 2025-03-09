package com.pedido.data.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;

import com.pedido.data.repository.ParametroImpostoRepository;

@ExtendWith(MockitoExtension.class)
class RecuperarTaxaImpostoCacheServiceImplTest {

    @Mock
    private ParametroImpostoRepository parametroImpostoRepository;

    @InjectMocks
    private RecuperarTaxaImpostoCacheServiceImpl recuperarTaxaImpostoCacheServiceImpl;

    private CacheManager cacheManager;

    @BeforeEach
    void setUp() {
        cacheManager = new SimpleCacheManager();
        ((SimpleCacheManager) cacheManager).setCaches(Collections.singletonList(new ConcurrentMapCache("taxaImpostoCache")));
        ((SimpleCacheManager) cacheManager).afterPropertiesSet();
    }

    @Test
    void testRecuperaParametroImposto() {

    	BigDecimal taxaImposto = BigDecimal.valueOf(0.2);
        when(parametroImpostoRepository.recuperaParametroImposto()).thenReturn(taxaImposto);

        BigDecimal resultado = recuperarTaxaImpostoCacheServiceImpl.recuperaParametroImposto();

        assertEquals(taxaImposto, resultado);
        verify(parametroImpostoRepository, times(1)).recuperaParametroImposto();

        Cache cache = cacheManager.getCache("taxaImpostoCache");
        assertNotNull(cache);

    }

    @Test
    void testRecuperaParametroImpostoComCache() {
        BigDecimal taxaImposto = BigDecimal.valueOf(0.2);
        when(parametroImpostoRepository.recuperaParametroImposto()).thenReturn(taxaImposto);

        recuperarTaxaImpostoCacheServiceImpl.recuperaParametroImposto();
        BigDecimal resultado = recuperarTaxaImpostoCacheServiceImpl.recuperaParametroImposto();

        assertEquals(taxaImposto, resultado);
    }
}
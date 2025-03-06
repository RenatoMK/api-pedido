package com.pedido.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.api.dto.PedidoRequestDTO;
import com.pedido.api.dto.PedidoResponseDTO;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/pedidos")
@Slf4j
public class PedidoApi {

	@Autowired
    private CriarPedidoCaseUser criarPedidoCaseUser;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
    	log.info("Inicia Criacao Pedido " + pedidoRequestDTO.getPedidoId());
        return ResponseEntity.status(HttpStatus.CREATED).body(criarPedidoCaseUser.criarPedido(pedidoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedido(@PathVariable Long id) {
        return null;
        	//	pedidoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
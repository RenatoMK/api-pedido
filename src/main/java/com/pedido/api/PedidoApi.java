package com.pedido.api;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.api.dto.CriarPedidoItemRequestDTO;
import com.pedido.api.dto.CriarPedidoResponseDTO;
import com.pedido.api.dto.RecuperarPedidoListResponseDTO;
import com.pedido.api.dto.RecuperarPedidoResponseDTO;
import com.pedido.domain.caseuser.AtualizarTaxaImpostoCaseUser;
import com.pedido.domain.caseuser.BuscarPedidoCaseUser;
import com.pedido.domain.caseuser.CriarPedidoCaseUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/pedidos")
@Slf4j
@RequiredArgsConstructor
public class PedidoApi {

	private final CriarPedidoCaseUser criarPedidoCaseUser;

	private final BuscarPedidoCaseUser buscarPedidoCaseUser;
	
	private final AtualizarTaxaImpostoCaseUser atualizarTaxaImpostoCaseUser;

	@PostMapping
	public ResponseEntity<CriarPedidoResponseDTO> criarPedido(
			@RequestBody CriarPedidoItemRequestDTO criarPedidoItemRequestDTO) {
		log.info("Inicia Criacao Pedido " + criarPedidoItemRequestDTO.getPedidoId());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(criarPedidoCaseUser.criarPedido(criarPedidoItemRequestDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecuperarPedidoResponseDTO> buscarPedidoPorId(@PathVariable Long id) {
		log.info("Inicia a busca por id " + id);

		return ResponseEntity.status(HttpStatus.OK).body(buscarPedidoCaseUser.buscarPedidoPorId(id));

	}

	@GetMapping
	public ResponseEntity<RecuperarPedidoListResponseDTO> buscarPedidoPorStatus(@RequestParam(required = false) String status) {
		log.info("Inicia a busca por Status " + status);

		return ResponseEntity.status(HttpStatus.OK).body(buscarPedidoCaseUser.buscarPedidoPorStatus(status));

	}
	
	@PatchMapping
	public ResponseEntity<Void> atualizarTaxaImposto(@RequestParam BigDecimal taxaImposto, @RequestParam String descriçãoImposto) {
		log.info("Inicia atualizacao taxa de imposto " + taxaImposto);

		atualizarTaxaImpostoCaseUser.atualizarTaxaImposto(taxaImposto, descriçãoImposto);
		
		log.info("Fim atualizacao taxa de imposto " + taxaImposto);
		
		return ResponseEntity.noContent().build();

	}
}
package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João das Couves 123");
		cliente1.setTelefone("61 99999-2345");
		cliente1.setEmail("joaodascouves@algaworks.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria da Silva");
		cliente2.setTelefone("62 98765-2345");
		cliente2.setEmail("mariadasilva@algaworks.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}

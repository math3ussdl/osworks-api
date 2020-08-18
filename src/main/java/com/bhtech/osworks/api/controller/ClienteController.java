package com.bhtech.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhtech.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Hugo dos Teclados");
		cliente1.setTelefone("81 98989-8141");
		cliente1.setEmail("hugolima1213@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Bruno dos violinos");
		cliente2.setTelefone("81 98500-8415");
		cliente2.setEmail("basl.limasilva1551@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}

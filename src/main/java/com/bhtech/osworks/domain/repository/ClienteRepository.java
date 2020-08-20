package com.bhtech.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhtech.osworks.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNome(String nome); // Pesquisa por nome inteiro
	List<Cliente> findByNomeContaining(String nome);    // parte do nome
	Cliente findByEmail(String email);
	
}

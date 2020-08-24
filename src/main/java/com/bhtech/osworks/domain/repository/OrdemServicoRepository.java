package com.bhtech.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhtech.osworks.domain.model.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}

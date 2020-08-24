package com.bhtech.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtech.osworks.api.model.Comentario;
import com.bhtech.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.bhtech.osworks.domain.exception.NegocioException;
import com.bhtech.osworks.domain.model.Cliente;
import com.bhtech.osworks.domain.model.OrdemServico;
import com.bhtech.osworks.domain.model.StatusOrdemServico;
import com.bhtech.osworks.domain.repository.ClienteRepository;
import com.bhtech.osworks.domain.repository.ComentarioRepository;
import com.bhtech.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado!"));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());

		return repository.save(ordemServico);
	}

	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		
		repository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);

		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);
	}

	private OrdemServico buscar(Long ordemServicoId) {
		return repository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada!"));
	}

}

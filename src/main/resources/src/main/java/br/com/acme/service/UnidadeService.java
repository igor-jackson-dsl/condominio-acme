package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.model.Unidade;
import br.com.acme.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository repository;

	@Transactional(readOnly = true)
	public List<Unidade> list() {
		return this.repository.findAll();
	}
	/*
	 * @Transactional(readOnly = true) public List<UnidadeMultaDto>
	 * getUnidadeWithMulta() { return this.repository.getUnidadeWithMulta(); }
	 */

	@Transactional
	public void save(Unidade unidade) {
		this.repository.save(unidade);
	}

	@Transactional(readOnly = true)
	public Optional<Unidade> getById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}

}

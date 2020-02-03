package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.model.Responsavel;
import br.com.acme.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository repository;

	@Transactional(readOnly = true)
	public List<Responsavel> list() {
		return this.repository.findAll();
	}

	@Transactional
	public void save(Responsavel responsavel) {
		this.repository.save(responsavel);
	}

	@Transactional(readOnly = true)
	public Optional<Responsavel> getById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}

}

package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.model.Multa;
import br.com.acme.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository repository;

	@Transactional(readOnly = true)
	public List<Multa> list() {
		return this.repository.findAll();
	}

	@Transactional
	public void save(Multa multa) {
		this.repository.save(multa);
	}

	@Transactional(readOnly = true)
	public Optional<Multa> getById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}

}

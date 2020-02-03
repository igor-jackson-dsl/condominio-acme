package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.model.Condominio;
import br.com.acme.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repository;

	@Transactional(readOnly = true)
	public List<Condominio> list() {
		return this.repository.findAll();
	}

	@Transactional
	public void save(Condominio condominio) {
		this.repository.save(condominio);
	}

	@Transactional(readOnly = true)
	public Optional<Condominio> getById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional(readOnly = true)
	public Boolean ifExist(Long id) {
		boolean a = false;
		if (!this.repository.findById(id).isPresent()) {
			a = true;
		}
		return a;
	}

	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}

}

package br.com.acme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.model.Condominio;
import br.com.acme.service.CondominioService;

@RestController
@RequestMapping("/api/condominios")
public class CondominioController {

	@Autowired
	private CondominioService service;

	@GetMapping()
	public List<Condominio> getAll() {
		return service.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Condominio> getCondById(@PathVariable Long id) {
		Optional<Condominio> condominioOptional = this.service.getById(id);
		Condominio condominio = condominioOptional.get();
		return ResponseEntity.ok(condominio);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<Condominio> save(@RequestBody Condominio condominio) {
		this.service.save(condominio);
		return new ResponseEntity<Condominio>(condominio, HttpStatus.CREATED);
	}

}

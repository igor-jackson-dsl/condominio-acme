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

import br.com.acme.model.Unidade;
import br.com.acme.service.CondominioService;
import br.com.acme.service.MultaService;
import br.com.acme.service.UnidadeService;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

	@Autowired
	private UnidadeService service;
	@Autowired
	private CondominioService condService;
	@Autowired
	private MultaService MultaService;

	@GetMapping
	public List<Unidade> getAll() {
		return service.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Unidade> getUnidadeById(@PathVariable Long id) {
		Optional<Unidade> unidadeOptional = this.service.getById(id);
		Unidade unidade = unidadeOptional.get();
		return ResponseEntity.ok(unidade);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/salvarUnidade/{condominioId}")
	public ResponseEntity<Unidade> save(@PathVariable Long condominioId, @RequestBody Unidade unidade) {

		unidade.setCondominioUnidade(condService.getById(condominioId).get());
		this.service.save(unidade);
		return new ResponseEntity<Unidade>(unidade, HttpStatus.CREATED);
	}

}

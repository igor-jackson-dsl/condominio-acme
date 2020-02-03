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

import br.com.acme.model.Aviso;
import br.com.acme.service.AvisoService;
import br.com.acme.service.CondominioService;
import br.com.acme.service.UnidadeService;

@RestController
@RequestMapping("/api/avisos")
public class AvisoController {

	@Autowired
	private AvisoService service;
	@Autowired
	private CondominioService condService;
	@Autowired
	private UnidadeService unidadeService;

	@GetMapping
	public List<Aviso> getAll() {
		return service.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aviso> getAvisoById(@PathVariable Long id) {
		Optional<Aviso> avisoOptional = this.service.getById(id);
		Aviso aviso = avisoOptional.get();
		return ResponseEntity.ok(aviso);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/emitirAviso/{condId}/{unidadeId}")
	public ResponseEntity<Aviso> save(@PathVariable Long condId, @PathVariable Long unidadeId,
			@RequestBody Aviso aviso) {

		aviso.setCondominioAvisos(condService.getById(condId).get());
		aviso.setUnidadeAviso(unidadeService.getById(unidadeId).get());
		this.service.save(aviso);
		return new ResponseEntity<Aviso>(aviso, HttpStatus.CREATED);
	}

}

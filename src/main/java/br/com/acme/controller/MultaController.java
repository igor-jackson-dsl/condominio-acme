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

import br.com.acme.model.Multa;
import br.com.acme.service.CondominioService;
import br.com.acme.service.MultaService;
import br.com.acme.service.UnidadeService;

@RestController
@RequestMapping("api/multas")
public class MultaController {

	@Autowired
	private MultaService service;
	@Autowired
	private UnidadeService unidadeService;
	@Autowired
	private CondominioService condService;

	@GetMapping
	public List<Multa> getAll() {
		return service.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Multa> getMultaById(@PathVariable Long id) {
		Optional<Multa> multaOptional = this.service.getById(id);
		Multa multa = multaOptional.get();
		return ResponseEntity.ok(multa);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/emitirMultas/{condId}/{unidadeId}")
	public ResponseEntity<Multa> save(@PathVariable Long condId, @PathVariable Long unidadeId,
			@RequestBody Multa multa) {

		multa.setUnidadeMulta(unidadeService.getById(unidadeId).get());
		multa.setCondominoMulta(condService.getById(condId).get());
		this.service.save(multa);
		return new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
	}

}

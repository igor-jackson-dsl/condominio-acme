package br.com.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.model.Responsavel;
import br.com.acme.service.ResponsavelService;

@RestController
@RequestMapping("api/responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<Responsavel> save(@RequestBody Responsavel responsavel) {
		this.service.save(responsavel);
		return new ResponseEntity<Responsavel>(responsavel, HttpStatus.CREATED);
	}

}

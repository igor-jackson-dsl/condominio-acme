package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long> {

}

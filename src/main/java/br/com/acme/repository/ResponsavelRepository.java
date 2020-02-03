package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.model.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}

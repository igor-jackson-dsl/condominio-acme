package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}

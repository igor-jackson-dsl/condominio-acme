/**
 * 
 */
package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.model.Condominio;

/**
 * @author Igor
 *
 */
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

}

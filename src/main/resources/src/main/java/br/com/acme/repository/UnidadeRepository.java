/**
 * 
 */
package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.model.Unidade;

/**
 * @author Igor
 *
 */
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	// @Query("SELECT new br.com.acme.model.dto.UnidadeMultaDto( u.id,
	// u.numeroUnidade, u.blocoUnidade, m.id as id_multa ) FROM Unidade u , Multa m
	// WHERE u.id = m.id_unidade")
	// public List<UnidadeMultaDto>getUnidadeWithMulta();

}

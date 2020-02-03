/**
 * 
 */
package br.com.acme.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tb_multas")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricaoMulta;

	private String dataMulta;

	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidadeMulta;

	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominoMulta;

	private String valorMulta;

	public Multa() {
	}
}

/**
 * 
 */
package br.com.acme.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tb_condominio")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Condominio implements Serializable {
	private static final long serialVersionUID = 1L;

	public Condominio() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String email;

	private String telefone;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioUnidade")
	private Set<Unidade> unidades;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominoMulta")
	@JsonIgnore
	private Set<Multa> multasAplicadas;

	@OneToMany
	@JsonIgnore
	private Set<Aviso> avisos;

}

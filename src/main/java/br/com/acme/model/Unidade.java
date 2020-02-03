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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tb_unidade")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Unidade implements Serializable {
	public Unidade() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavelUnidade;

	private String numeroUnidade;

	private String blocoUnidade;

	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominioUnidade;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMulta")
	@JsonIgnore
	private Set<Multa> multasUnidade;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeAviso")
	@JsonIgnore
	private Set<Aviso> avisosUnidade;

}

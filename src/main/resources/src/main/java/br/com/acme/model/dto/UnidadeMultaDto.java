package br.com.acme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnidadeMultaDto {

	private String id;
	private String numero_unidade;
	private String bloco_unidade;
	private String id_multa;

}

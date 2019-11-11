package br.com.infogomes.starwarsplanetas.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.infogomes.starwarsplanetas.model.Planet;

@SuppressWarnings("deprecation")
public class PlanetDTO {

	private int id;

	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Length(min = 2, max = 30, message = "O tamanho deve ser entre 2 e 30 caracteres")
	private String nome;

	@Digits(integer = 6, fraction = 2, message = "Só números são permitidos")
	//@Pattern(regexp = "[0-9]", message = "Só números são permitidos. ")
	private BigDecimal temperatura;

	@NotEmpty(message = "Preenchimento Obrigatório.")
	@Length(min = 2, max = 30, message = "O tamanho deve ser entre 2 e 30 caracteres")
	private String terreno;

	public PlanetDTO() {

	}

	public PlanetDTO(Planet planet) {
		this.id = planet.getId();
		this.nome = planet.getNome();
		this.temperatura = planet.getTemperatura();
		this.terreno = planet.getTerreno();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

}

package br.com.infogomes.starwarsplanetas.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_planet")
public class Planet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "planeta_nome")
	private String nome;

	@Column(name = "planeta_temperatura")
	private BigDecimal temperatura;

	@Column(name = "planeta_terreno")
	private String terreno;

	public Planet() {
	}

	public Planet(int id, String nome, BigDecimal temperatura, String terreno) {
		super();
		this.id = id;
		this.nome = nome;
		this.temperatura = temperatura;
		this.terreno = terreno;
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

	@Override
	public String toString() {
		return "Planet [nome=" + nome + ", temperatura=" + temperatura + ", terreno=" + terreno + "]";
	}

}

package br.com.infogomes.starwarsplanetas.service;

import java.util.List;

import javax.validation.Valid;

import br.com.infogomes.starwarsplanetas.dto.PlanetDTO;
import br.com.infogomes.starwarsplanetas.model.Planet;



public interface PlanetService {

	public List<Planet> getPlanets();

	public int savePlanet(Planet planet);

	public Planet getPlanet(int id);

	public void deletePlanet(int id);

	public void updatePlanet(Planet planet);

	public Planet fromDTO(@Valid PlanetDTO planetDTO);

}

package br.com.infogomes.starwarsplanetas.repository;

import java.util.List;

import br.com.infogomes.starwarsplanetas.model.Planet;

public interface PlanetRepository {

	public List<Planet> getPlanets();

	public int savePlanet(Planet planet);

	public Planet getPlanet(int id);

	public void deletePlanet(Planet planet);

	public void updatePlanet(Planet planet);

}

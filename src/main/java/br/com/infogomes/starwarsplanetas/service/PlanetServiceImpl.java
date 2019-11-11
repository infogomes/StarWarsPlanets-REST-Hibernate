package br.com.infogomes.starwarsplanetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infogomes.starwarsplanetas.dto.PlanetDTO;
import br.com.infogomes.starwarsplanetas.model.Planet;
import br.com.infogomes.starwarsplanetas.repository.PlanetRepository;
import br.com.infogomes.starwarsplanetas.service.exception.ObjectNotFoundException;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	@Override
	@Transactional
	public List<Planet> getPlanets() {
		return planetRepository.getPlanets();
	}

	@Override
	@Transactional
	public int savePlanet(Planet planet) {
		return planetRepository.savePlanet(planet);

	}

	@Override
	@Transactional
	public Planet getPlanet(int id) {
		Planet planet = planetRepository.getPlanet(id);
		if (planet == null) {
			throw new ObjectNotFoundException(
					"Planeta não encontrado! Id: " + id + ", Tipo: " + Planet.class.getName());
		}
		return planet;
	}

	@Override
	@Transactional
	public void deletePlanet(int id) {
		Planet planet = getPlanet(id);
		planetRepository.deletePlanet(planet);

	}

	@Override
	@Transactional
	public void updatePlanet(Planet planet) {
		getPlanet(planet.getId());
		planetRepository.updatePlanet(planet);

	}

	public Planet fromDTO(PlanetDTO planetDTO) {
		return new Planet(planetDTO.getId(), planetDTO.getNome(), planetDTO.getTemperatura(), planetDTO.getTerreno());
	}

}

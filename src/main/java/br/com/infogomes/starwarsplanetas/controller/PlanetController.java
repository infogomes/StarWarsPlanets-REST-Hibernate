package br.com.infogomes.starwarsplanetas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.infogomes.starwarsplanetas.dto.PlanetDTO;
import br.com.infogomes.starwarsplanetas.model.Planet;
import br.com.infogomes.starwarsplanetas.service.PlanetService;

@RestController
@RequestMapping(value = "/planet")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody PlanetDTO planetDTO) {
		Planet planet = planetService.fromDTO(planetDTO);
		int id = planetService.savePlanet(planet);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Planet> get(@PathVariable("id") int id) {
		Planet planet = planetService.getPlanet(id);
		return ResponseEntity.ok().body(planet);
	}

	@GetMapping
	public ResponseEntity<List<Planet>> list() {
		List<Planet> planets = planetService.getPlanets();
		return ResponseEntity.ok().body(planets);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @Valid @RequestBody PlanetDTO planetDTO) {
		Planet planet = planetService.fromDTO(planetDTO);
		planetService.updatePlanet(planet);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		planetService.deletePlanet(id);
		return ResponseEntity.noContent().build();
	}

}

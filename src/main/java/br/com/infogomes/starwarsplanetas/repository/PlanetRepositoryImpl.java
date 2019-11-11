package br.com.infogomes.starwarsplanetas.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infogomes.starwarsplanetas.model.Planet;

@Repository
public class PlanetRepositoryImpl implements PlanetRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Planet> getPlanets() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Planet> cq = cb.createQuery(Planet.class);
		Root<Planet> root = cq.from(Planet.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public int savePlanet(Planet planet) {
		Session currentSession = sessionFactory.getCurrentSession();
		int id = (int) currentSession.save(planet);
		return id;
	}

	@Override
	public Planet getPlanet(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Planet planet = currentSession.get(Planet.class, id);
		return planet;
	}

	@Override
	public void deletePlanet(Planet planet) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(planet);
	}

	@Override
	public void updatePlanet(Planet planet) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(planet);
	}

}

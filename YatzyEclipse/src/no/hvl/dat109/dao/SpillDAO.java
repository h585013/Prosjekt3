package no.hvl.dat109.dao;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.spill.Spill;

@Stateless
public class SpillDAO {
	@PersistenceContext(name = "spillPU")
	private EntityManager em;

	public void leggTilSpill(Spill spill) {
		em.persist(spill);
	}

	public Spill finnSpill(Long id) {
		return em.find(Spill.class, id);
	}
// finn admin(er brukernavn til den som lagde spillet) i spill ?

// hente ut listen med alle spillere

// legg til spiller i spill

//slett spill

}
